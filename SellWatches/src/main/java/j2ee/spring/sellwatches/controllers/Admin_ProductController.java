package j2ee.spring.sellwatches.controllers;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import j2ee.spring.sellwatches.impl.CategoryServiceImplement;
import j2ee.spring.sellwatches.impl.ProductServiceImplement;
import j2ee.spring.sellwatches.models.Category;
import j2ee.spring.sellwatches.models.Product;
import j2ee.spring.sellwatches.models.Trademark;
import j2ee.spring.sellwatches.services.ProductService;
import j2ee.spring.sellwatches.services.TrademarkService;

@Component
@Controller
public class Admin_ProductController {

	// Số sản phẩm trên trang
	private final int NUMBER_PRODUCT_ON_PAGE = 10;
	// Số trang hiển thị
	private final int NUMBER_PAGE_VIEW = 5;
	@Autowired
	ProductService service;
	@Autowired
	TrademarkService trademarkService;
	@Autowired
	CategoryServiceImplement categoryService;

	public Admin_ProductController(ProductServiceImplement imp) {
		service = imp;
		// TODO Auto-generated constructor stub
	}

	// index
	@RequestMapping(value = "/admin/products", method = RequestMethod.GET)
	public String index(@RequestParam("page") int page, Model model) {
		// Lấy danh sản phẩm
		List<Product> products = new ArrayList<Product>();
		products = service.select();
		// >>>>>> tính toán thanh phân trang
		// Số trang
		// nếu số sản phẩm (n) chi hết cho số sản phẩm 1 trang (p) thì có n/p trang
		// Ngược lại có n/p+1 trang
		int numberPage = products.size() % NUMBER_PRODUCT_ON_PAGE == 0 ? products.size() / NUMBER_PRODUCT_ON_PAGE
				: products.size() / NUMBER_PRODUCT_ON_PAGE + 1;
		if (page > numberPage) {
			return "redirect:/admin/products?page=" + numberPage;
		}
		// vị trì bắt đầu là số lượng sản phẩm trên trang (n) * (Page -1)
		int beginIndex = NUMBER_PRODUCT_ON_PAGE * (page - 1);
		// vị trí kết thúc là số nhỏ nhất giữa hai số là số sản phẩm tối đa và
		// beginIndex + NUMBER_PRODUCT_ON_PAGE
		// có cách tính khác là beginIndex + NUMBER_PRODUCT_ON_PAGE =
		// NUMBER_PRODUCT_ON_PAGE*(page)-1
		int endIndex = Math.min(NUMBER_PRODUCT_ON_PAGE * (page) - 1, products.size() - 1);
		// Trang bắt đầu
		int pageBegin = page <= 1.0 * NUMBER_PAGE_VIEW / 2 ? 1 : page - NUMBER_PAGE_VIEW / 2;
		// Trang kết thúc
		int pageEnd = page >= numberPage - 1.0 * NUMBER_PAGE_VIEW / 2 ? numberPage : page + NUMBER_PAGE_VIEW / 2;
		// truyển dữ liệu ra màn hình
		model.addAttribute("products", products.subList(beginIndex, endIndex + 1));
		model.addAttribute("beginIndex", beginIndex);
		model.addAttribute("endIndex", endIndex);
		model.addAttribute("pageBegin", pageBegin);
		model.addAttribute("pageEnd", pageEnd);
		model.addAttribute("page", page);
		model.addAttribute("numberPage", numberPage);
		return "admin_product";
	}

	// edit
	@RequestMapping(value = "/admin/products/edit", method = RequestMethod.GET)
	public String edit(@RequestParam("id") int id, Model model) {

		// lấy danh sách thương hiệu
		List<Trademark> listTrademarks = trademarkService.select();
		model.addAttribute("trademarks", listTrademarks);
		// lấy danh sách Loại sp
		List<Category> listCategory = categoryService.select();
		model.addAttribute("categories", listCategory);
		Object[] idPara = { id };
		// Lấy thông tin sản phẩm
		Product product = service.findById(idPara);
		model.addAttribute("product", product);
		return "admin_edit_product";
	}

	@RequestMapping(value = "/admin/products/edit", method = RequestMethod.POST)
	public String edit_submit(@RequestParam("fileBigImg") MultipartFile fileBigImg,
			@RequestParam("fileSmall") MultipartFile[] fileSmall, Product product, Model model,
			HttpServletRequest request) {
		int idTrademark = Integer.parseInt(request.getParameter("idTrademark"));
		String idCategory = request.getParameter("idCategory");
		// Lấy đối tượng product
		Object[] idPara = { product.getId() };
		Product old_product = service.findById(idPara);
		// Lấy thông tin trademark
		Object[] id_t = { idTrademark };
		Trademark trademark = trademarkService.findById(id_t);
		// lấy thông tin category
		Object[] id_c = { idCategory };
		Category category = categoryService.findById(id_c);
		// đặt lại tên file
		File bigImageFile = new File(
				request.getServletContext().getRealPath("/resources/images/HINHLON/" + old_product.getBigImage()));
		try {
			if (!fileBigImg.isEmpty())
				fileBigImg.transferTo(bigImageFile);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int index = 1;
		for (MultipartFile fitem : fileSmall) {
			File smallFile = new File(request.getServletContext()
					.getRealPath("/resources/images/HINHNHO/" + old_product.getSmallImage() + "/" + index + ".jpg"));
			try {
				if (!fitem.isEmpty())
					fitem.transferTo(smallFile);
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			index++;
		}
		// update
		old_product.setCategory(category);
		old_product.setDescription(product.getDescription());
		old_product.setTrademark(trademark);
		old_product.setEvalute(product.getEvalute());
		old_product.setPrice(product.getPrice());
		service.update(old_product);
		return "admin_product";
	}

	@RequestMapping(value = "/admin/products/delete", method = RequestMethod.GET)
	public RedirectView delete(@RequestParam("id") int id, @RequestParam("page") int page,
			RedirectAttributes redirectAttributes) {
		// Xóa sản phẩm
		Object[] idPara = { id };
		service.delete(idPara);
		redirectAttributes.addAttribute("page", 1);
		return new RedirectView("/SellWatches/admin/products");
	}

	@RequestMapping(value = "/admin/products/add", method = RequestMethod.GET)
	public String addProduct(Model model) {
		// lấy danh sách thương hiệu
		List<Trademark> listTrademarks = trademarkService.select();
		model.addAttribute("trademarks", listTrademarks);
		// lấy danh sách Loại sp
		List<Category> listCategory = categoryService.select();
		model.addAttribute("categories", listCategory);
		model.addAttribute("product",new Product());
		return "admin_add_product";
	}

	@RequestMapping(value = "/admin/products/addsubmit", method = RequestMethod.POST)
	public String addProduct(@RequestParam("fileBigImg") MultipartFile fileBigImg,
			@RequestParam("fileSmall") MultipartFile[] fileSmall,@RequestParam("idTrademark") int idTrademark,
			@RequestParam("idCategory") String idCategory,
			@ModelAttribute("product") Product product, Model model,
			HttpServletRequest request) {

//		int idTrademark = Integer.parseInt(request.getParameter("idTrademark"));
//		String idCategory = request.getParameter("idCategory");
		// Lấy thông tin trademark
		Object[] id_t = { idTrademark };
		Trademark trademark = trademarkService.findById(id_t);
//		// lấy thông tin category
		Object[] id_c = { idCategory };
		Category category = categoryService.findById(id_c);

		String fileName = fileBigImg.getOriginalFilename();
		String[] arr = StringUtils.split(fileName,".");
		String folder = arr[0];
		// đặt lại tên file
		File bigImageFile = new File(request.getServletContext().getRealPath("/resources/images/HINHLON/" + fileName));
		if (!bigImageFile.exists()) {
			bigImageFile.mkdirs();
		}
		try {
			if (!fileBigImg.isEmpty())
				fileBigImg.transferTo(bigImageFile);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int index = 1;
		// Thêm thư mục 
		File foderSmall = new File(request.getServletContext().getRealPath("/resources/images/HINHNHO/" + folder));
		if (!foderSmall.exists()) {
			foderSmall.mkdirs();
		}
		for (MultipartFile fitem : fileSmall) {
			File smallFile = new File(request.getServletContext()
					.getRealPath("/resources/images/HINHNHO/" + folder + "/" + index + ".jpg"));
			if (!smallFile.exists()) {
				smallFile.mkdirs();
			}
			try {
				if (!fitem.isEmpty())
					fitem.transferTo(smallFile);
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			index++;
		}
		// Add
		product.setBigImage(fileName);
		product.setCategory(category);
		product.setNumber(0);
		product.setSmallImage(folder);
		product.setTrademark(trademark);
		service.insert(product);
		return "admin_add_product";
	}

}
