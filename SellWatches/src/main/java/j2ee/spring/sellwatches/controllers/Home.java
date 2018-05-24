package j2ee.spring.sellwatches.controllers;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import j2ee.spring.sellwatches.common.CommonConstands;
import j2ee.spring.sellwatches.impl.ProductServiceImplement;
import j2ee.spring.sellwatches.models.Product;
import j2ee.spring.sellwatches.services.ProductService;
import j2ee.spring.sellwatches.viewmodel.CartViewModel;
import j2ee.spring.sellwatches.viewmodel.HomeViewModel;
import j2ee.spring.sellwatches.viewmodel.ProductOnView;

@Controller
@Component
public class Home {
	
	ProductService service;
	
	@Autowired
	public Home(ProductServiceImplement impl)
	{
		service = impl;
	}
	
	@RequestMapping(value = {"/Index","/"})
	public String  Index(Model model, HttpSession httpSession)
	{
		HomeViewModel viewModel = new HomeViewModel();
		// lấy danh sách sản phầm bán chạy với 4 thuộc tính. Tên, Mô tả, Hình hảnh, mã sản phẩm (lấy 3 sản phẩm)
		List<Product> lstSellingProduct = service.getSellingProduct(3);
		viewModel.setSellingProduct(lstSellingProduct);
		// lấy danh sách sản phẩm mới nhất lấy 8 sản phẩm
		List<ProductOnView> lstNewProduct = service.getNewProduct(8);
		model.addAttribute("lstSellingProduct",lstSellingProduct);
		model.addAttribute("lstNewProduct",lstNewProduct);
		
		if(httpSession.getAttribute(CommonConstands.CART_SESSION) != null) {
			List<CartViewModel> listCarts = (List<CartViewModel>) httpSession.getAttribute(CommonConstands.CART_SESSION);
			model.addAttribute("quantityCart", listCarts.size());
		}
		
		return "home";
	}
}
