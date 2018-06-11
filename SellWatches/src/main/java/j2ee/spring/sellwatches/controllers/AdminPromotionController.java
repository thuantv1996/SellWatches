package j2ee.spring.sellwatches.controllers;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import j2ee.spring.sellwatches.common.CommonConstands;
import j2ee.spring.sellwatches.dao.DetailPromotionDAO;
import j2ee.spring.sellwatches.models.DetailPromotion;
import j2ee.spring.sellwatches.models.Promotion;
import j2ee.spring.sellwatches.services.PromotionService;
import j2ee.spring.sellwatches.viewmodel.PromotionAdminViewModel;

@Controller
@Component
@SessionAttributes(CommonConstands.ADMIN_SESSION)
public class AdminPromotionController {

	private static final int RECORD_ON_PAGE = 10;
	private static final int NUMBER_PAGE_DISPLAY = 5;
	@Autowired
	private PromotionService service;

	 @InitBinder
	 public final void initBinderUsuariosFormValidator(final WebDataBinder binder, final Locale locale) {
	     final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", locale);
	     binder.registerCustomEditor(Timestamp.class, new CustomDateEditor(dateFormat, true));    
	 }
	
	@RequestMapping(value = "admin/promotion", method = RequestMethod.GET)
	public String index(Model model, int page,HttpSession httpSession) {
		if(httpSession.getAttribute(CommonConstands.ADMIN_SESSION) == null) {
			return "redirect: login ";
		}
		// Lấy danh sách Promotion
		List<Promotion> lstPromotion = service.getList();
		int numberRecord = lstPromotion.size();
		/* Phân Trang */
		// tính tổng số trang
		int totalPage = numberRecord % RECORD_ON_PAGE == 0 ? numberRecord / RECORD_ON_PAGE
				: numberRecord / RECORD_ON_PAGE + 1;
		if(page>totalPage)
		{
			return "redirect:/admin/promotion?page="+totalPage;
		}
		// tìm số trang bắt đầu trên thanh paging
		int beginPageDisplay = page <= NUMBER_PAGE_DISPLAY / 2.0 ? 1 : page - NUMBER_PAGE_DISPLAY / 2;
		// tìm trang kết thúc trên thanh paging
		int endPageDisplay = page + NUMBER_PAGE_DISPLAY / 2.0 > totalPage ? totalPage : page + NUMBER_PAGE_DISPLAY / 2;
		// tìm bảng ghi bắt đầu
		int beginRecord = (page -1)*RECORD_ON_PAGE;
		// Tìm bảng ghi kết thúc
		int endRecord = Math.min(RECORD_ON_PAGE* page - 1, numberRecord -1 );
		// truyền ra view
		model.addAttribute("promotions", lstPromotion.subList(beginRecord, endRecord + 1));
		model.addAttribute("beginPageDisplay",beginPageDisplay);
		model.addAttribute("endPageDisplay",endPageDisplay);
		model.addAttribute("page",page);
		// return
		return "admin_promotion";
	}

	@RequestMapping(value = "admin/promotion/add",method = RequestMethod.GET)
	public String add(Model model,HttpSession httpSession) {
		if(httpSession.getAttribute(CommonConstands.ADMIN_SESSION) == null) {
			return "redirect: ../login ";
		}
		Timestamp currentTime = new Timestamp(System.currentTimeMillis());
		Promotion promotion = new Promotion();
		promotion.setBeginDay(currentTime);
		promotion.setEndDay(currentTime);
		model.addAttribute("promotion",promotion);
		model.addAttribute("error",new ArrayList<String>());
		return "admin_add_promotion";
	}
	
	@RequestMapping(value = "admin/promotion/add",method = RequestMethod.POST)
	public String addSubmit(Model model,@ModelAttribute("promotion") PromotionAdminViewModel promotion) {
		List<String> errorMessage = new ArrayList<>();
		boolean isError = false;
		// Khai báo iến lưu dữ liệu từ View
		Promotion p = new Promotion();
		
		// Định dạng ngày tháng
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		// Lấy ngày bắt đầu và kết thúc từ  view
		Timestamp beginDay = null;
		Timestamp endDay = null;
		try {
			beginDay = new Timestamp(dateFormat.parse(promotion.getBeginDay()).getTime());
			endDay = new Timestamp(dateFormat.parse(promotion.getEndDay()).getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		// Kiểm tra dữ liệu
		if(promotion.getNamePromotion().isEmpty())
		{
			errorMessage.add("Tên khuyến mãi khác rỗng");
			isError = true;
		}
		if(beginDay == null)
		{
			errorMessage.add("Nhập ngày bắt đầu khuyến mãi");
			isError = true;
		}
		if(endDay == null)
		{
			errorMessage.add("Nhập ngày kết thúc khuyến mãi");
			isError = true;
		}
		if(beginDay.after(endDay))
		{
			errorMessage.add("Ngày kết thúc không được phép diển ra trước ngày bắt đầu!");
			isError = true;
		}
		if(isError)
		{
			Promotion ePromotion = new Promotion();
			ePromotion.setBeginDay(beginDay);
			ePromotion.setEndDay(endDay);
			ePromotion.setNamePromotion(promotion.getNamePromotion());
			model.addAttribute("promotion",ePromotion);
			model.addAttribute("error",errorMessage);
			return "admin_add_promotion";
		}
		// lấy mã promotion lớn nhất
		String maxIdPromotion = service.getMaxId();
		// Lấy phần số trong ID
		String numberId = maxIdPromotion.substring(2, 7);
		// khai báo biến lưu trử ID tiếp theo
		String nextId = maxIdPromotion.substring(0, 2);
		// Tính số id tiếp theo
		int nextNumberId = Integer.parseInt(numberId)+1;
		for(int i=0;i<5-String.valueOf(nextNumberId).length();i++)
		{
			nextId+="0";
		}
		nextId+=nextNumberId;
		// Set Property
		p.setId(nextId);
		p.setNamePromotion(promotion.getNamePromotion());
		
		if(service.insert(p))
		{
			return "redirect:../promotion?page=1";
		}
		else
		{
			return "redirect:add";
		}
	}

	@RequestMapping(value = "admin/promotion/update",method = RequestMethod.GET)
	public String update(Model model,String id,HttpSession httpSession)
	{
		if(httpSession.getAttribute(CommonConstands.ADMIN_SESSION) == null) {
			return "redirect: ../login ";
		}
		// Lấy promotion 
		Object[] idPara = {id};
		Promotion vPromotion = service.findById(idPara);
		if(vPromotion == null)
		{
			return "redirect:../promotion?page=1";
		}
		model.addAttribute("promotion",vPromotion);
		model.addAttribute("error",new ArrayList<String>());
		return "admin_update_promotion";
	}
	
	@RequestMapping(value = "admin/promotion/update",method = RequestMethod.POST)
	public String updateSubmit(Model model,@ModelAttribute("promotion") PromotionAdminViewModel promotion) {
		List<String> errorMessage = new ArrayList<>();
		boolean isError = false;
		// Khai báo iến lưu dữ liệu từ View
		Promotion p = new Promotion();
		
		// Định dạng ngày tháng
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		// Lấy ngày bắt đầu và kết thúc từ  view
		Timestamp beginDay = null;
		Timestamp endDay = null;
		try {
			beginDay = new Timestamp(dateFormat.parse(promotion.getBeginDay()).getTime());
			endDay = new Timestamp(dateFormat.parse(promotion.getEndDay()).getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		// Kiểm tra dữ liệu
		if(promotion.getNamePromotion().isEmpty())
		{
			errorMessage.add("Tên khuyến mãi khác rỗng");
			isError = true;
		}
		if(beginDay == null)
		{
			errorMessage.add("Nhập ngày bắt đầu khuyến mãi");
			isError = true;
		}
		if(endDay == null)
		{
			errorMessage.add("Nhập ngày kết thúc khuyến mãi");
			isError = true;
		}
		if(beginDay.after(endDay))
		{
			errorMessage.add("Ngày kết thúc không được phép diển ra trước ngày bắt đầu!");
			isError = true;
		}
		if(isError)
		{
			Promotion ePromotion = new Promotion();
			ePromotion.setBeginDay(beginDay);
			ePromotion.setEndDay(endDay);
			ePromotion.setNamePromotion(promotion.getNamePromotion());
			model.addAttribute("promotion",ePromotion);
			model.addAttribute("error",errorMessage);
			return "admin_update_promotion";
		}
		
		Promotion mPromotion = new Promotion();
		// set property
		mPromotion.setId(promotion.getId());
		mPromotion.setNamePromotion(promotion.getNamePromotion());
		mPromotion.setBeginDay(beginDay);
		mPromotion.setEndDay(endDay);
		// uapdate
		service.update(mPromotion);
		return "redirect:../promotion?page=1";
	}
	
	@RequestMapping(value = "admin/promotion/delete",method = RequestMethod.GET)
	public String delete(Model model,String id,int page,HttpSession httpSession)
	{
		if(httpSession.getAttribute(CommonConstands.ADMIN_SESSION) == null) {
			return "redirect: ../login ";
		}
		// Lấy Promotion
		Object[] idPara = {id};
		Promotion vPromotion = service.findById(idPara);
		if(vPromotion == null)
		{
			return "redirect:../promotion?page="+page;
		}
		// Kiểm tra dữ liệu
		// Nếu có bất kỳ chi tiết nào thì không thể xóa
		DetailPromotionDAO detailPromotionDAO = new DetailPromotionDAO();		
		List<DetailPromotion> detailPromotions = detailPromotionDAO.findByIdPromotion(id);
		if(detailPromotions.size()>0)
		{
			return "redirect:../promotion?page="+page;
		}
		// nếu ngày bắt đầu đã diển ra thì không cho phép xóa
		Timestamp curDate = new Timestamp(System.currentTimeMillis());
		if(vPromotion.getBeginDay().before(curDate))
		{
			return "redirect:../promotion?page="+page;
		}
		// ngược lại cho phép xóa
		service.delete(idPara);
		return "redirect:../promotion?page="+page;
	}
}
