package j2ee.spring.sellwatches.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import j2ee.spring.sellwatches.impl.ProductServiceImplement;
import j2ee.spring.sellwatches.models.Product;
import j2ee.spring.sellwatches.viewmodel.ProductCategoryViewModel;
import java.util.stream.Stream;

@Controller
@Component
public class ProductsController {

	@Autowired
	ProductServiceImplement productService;
	
	@RequestMapping(method = RequestMethod.GET, value = "/Products")
	public String Products(@RequestParam("cateKey") String cateKey, @RequestParam("page") int page, ProductCategoryViewModel productCategoryViewModel, ModelMap modelMap) {
		
		productCategoryViewModel.setPageSize(8);
		productCategoryViewModel.setPageDislayNumber(5);
		
		if(cateKey.equals("All")) 
		{
			productCategoryViewModel.setListProduct(productService.LoadProductAll());
		}
		else 
		{
			if(cateKey.equals("Men"))
			{
				productCategoryViewModel.setListProduct(productService.LoadProductMen());
			}
			if(cateKey.equals("Women"))
			{
				productCategoryViewModel.setListProduct(productService.LoadProductWomen());
			}
		}
		
		modelMap.addAttribute("listProducts", productCategoryViewModel.getListProduct());
		
		int totalRecord = productCategoryViewModel.getListProduct().size();
		productCategoryViewModel.setCateKey(cateKey);
		productCategoryViewModel.setIndex(page);
		productCategoryViewModel.setTotalPage((int) Math.ceil(((double)totalRecord/productCategoryViewModel.getPageSize())));
		
		productCategoryViewModel.setStartPageIndex(Math.max(1, productCategoryViewModel.getIndex() - productCategoryViewModel.getPageDislayNumber() / 2));
		productCategoryViewModel.setEndPageIndex(Math.min(productCategoryViewModel.getTotalPage(), productCategoryViewModel.getIndex() + productCategoryViewModel.getPageDislayNumber() / 2));
		
		productCategoryViewModel.setIndexSublist((productCategoryViewModel.getIndex() - 1) * productCategoryViewModel.getPageSize());
		
		return "products";
	}
}
