package j2ee.spring.sellwatches.controllers;


import java.security.Provider.Service;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import j2ee.spring.sellwatches.common.CommonConstands;
import j2ee.spring.sellwatches.impl.ProductServiceImplement;
import j2ee.spring.sellwatches.models.DetailPromotion;
import j2ee.spring.sellwatches.models.DetailPromotionID;
import j2ee.spring.sellwatches.models.Product;
import j2ee.spring.sellwatches.services.DetailPromotionService;
import j2ee.spring.sellwatches.services.ProductService;
import j2ee.spring.sellwatches.viewmodel.DetailPromotionViewModel;

@Controller
@Component
@SessionAttributes(CommonConstands.ADMIN_SESSION)
public class AdminDetailPromotionController {
	
	@Autowired
	private DetailPromotionService sevice;
	
	@Autowired
	private ProductService productService;

	@RequestMapping(value = "admin/detail-promotion")
	public String index(String id,Model model,HttpSession httpSession)
	{
		if(httpSession.getAttribute(CommonConstands.ADMIN_SESSION) == null) {
			return "redirect: login ";
		}
		// Lấy danh sách sản phẩm
		List<Product> products = productService.select();
		model.addAttribute("products",products);
		// Trả Id Promotion cho view
		model.addAttribute("idPromotion",id);
		// Trả ra danh sách 
		List<DetailPromotionViewModel> detais = new ArrayList<>();
		detais = sevice.getList(id);
		model.addAttribute("detais",detais);
		return "admin_detail_promotion";
	}
	
	@RequestMapping(value = "admin/detail-promotion/add", method = RequestMethod.GET)
	@ResponseBody
	public String add(String idPromotion,int idProduct,int content)
	{
		DetailPromotion detailPromotion = new DetailPromotion();
		DetailPromotionID id = new DetailPromotionID();
		id.setProduct(idProduct);
		id.setPromotion(idPromotion);
		detailPromotion.setDetailPromotionID(id);
		detailPromotion.setContent(content);
		// kiểm tra xem đã có trong promotion này chưa
		Object[] idPara = {idPromotion,idProduct};
		if(sevice.findById(idPara)!=null)
		{
			if(sevice.update(detailPromotion))
			{
				return "Upadte suscess";
			}
			else
			{
				return "Update fail";
			}
		}
		if(sevice.insert(detailPromotion))
		{
			return "Add suscess";
		}
		else
		{
			return "Add fail";
		}
	}
	
	@RequestMapping(value = "admin/detail-promotion/delete", method = RequestMethod.GET)
	@ResponseBody
	public String delete(String idPromotion,int idProduct)
	{
		Object[] idPara = {idPromotion,idProduct};
		if(sevice.delete(idPara))
		{
			return "Deleted!";
		}
		else
		{
			return "Delete fail!";
		}
		
		
	}
}
