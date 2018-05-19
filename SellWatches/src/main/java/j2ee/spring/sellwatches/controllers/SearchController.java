package j2ee.spring.sellwatches.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import j2ee.spring.sellwatches.services.ProductService;
import j2ee.spring.sellwatches.viewmodel.ProductOnView;
import j2ee.spring.sellwatches.viewmodel.SearchViewModel;

@Controller
public class SearchController {
	
	private final int PAGE_SIZE = 8;
	private final int PAGE_NUMBER = 5;
	
	@Autowired
	private ProductService service;
	@RequestMapping(value = "/search")
	public String Index(@RequestParam("key") String key,@RequestParam("page") int page,Model model)
	{
		SearchViewModel viewModel = new SearchViewModel();
		viewModel.setCurPage(page);
		viewModel.setKey(key);
		List<ProductOnView> lstProdctOnView = new ArrayList<ProductOnView>();
		// Tìm danh sách sản phẩm có tên chứa key
		lstProdctOnView = service.findByKey(key);
		int totalPage = lstProdctOnView.size()%PAGE_SIZE!=0? lstProdctOnView.size()/PAGE_SIZE +1:lstProdctOnView.size()/PAGE_SIZE;
		viewModel.setTotalPage(totalPage);
		// Lấy ra n sản phẩm
		int beginIdex = PAGE_SIZE*(page-1);
		int endIndex = PAGE_SIZE*(page-1)+PAGE_SIZE;
		if(endIndex>lstProdctOnView.size())
		{
			endIndex = lstProdctOnView.size();
		}
		viewModel.setProducts(lstProdctOnView.subList(beginIdex, endIndex));
		// tính trang bắt đầu và trang kết thúc
		int beginPage = Math.max(1, page-PAGE_NUMBER/2);
		int endPage = Math.min(totalPage,beginPage+PAGE_NUMBER-1);
		viewModel.setBeginIndex(beginPage);
		viewModel.setEndIndex(endPage);
		// gọi view model
		model.addAttribute("viewModel",viewModel);
		return "search";
	}
	@RequestMapping(value = "/searchkey")
	public RedirectView  Index(@RequestParam("key") String key,RedirectAttributes redirectAttributes)
	{
		 redirectAttributes.addAttribute("key", key);
		 redirectAttributes.addAttribute("page", 1);
		 return new RedirectView("search");
	}
	
}
