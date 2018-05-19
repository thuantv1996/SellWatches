package j2ee.spring.sellwatches.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import j2ee.spring.sellwatches.services.ProductService;
import j2ee.spring.sellwatches.viewmodel.DetailViewModel;

@Controller
@Component
public class ProductDetail {

	@Autowired
	private ProductService service;
	private DetailViewModel detailViewModel;
	@RequestMapping("/ProductDetail")
	public String Index(@RequestParam("id") int id,Model model) {
		detailViewModel = new DetailViewModel();
		// Lấy thông tin sản phẩm
		detailViewModel.setProduct(service.getProductOnView(id));
		// Lấy danh sách sản phẩm liên quan 3 sp
		detailViewModel.setRelatedProducts(service.getRelativeProduct(id,3));
		// Lấy danh sách sản phẩm mới
		detailViewModel.setNewProducts(service.getNewProduct(5));
		model.addAttribute("viewModel",detailViewModel);
		return "productdetail";
	}
}
