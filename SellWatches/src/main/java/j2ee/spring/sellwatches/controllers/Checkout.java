package j2ee.spring.sellwatches.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import j2ee.spring.sellwatches.common.CommonConstands;
import j2ee.spring.sellwatches.viewmodel.CartViewModel;

@Controller
@Component
@SessionAttributes(CommonConstands.CART_SESSION)
public class Checkout {
	
	@RequestMapping(method = RequestMethod.GET, value = "/Checkout")
	public String Default(HttpSession httpSession, ModelMap modelMap) {
		if(httpSession.getAttribute(CommonConstands.CART_SESSION) != null) {
			List<CartViewModel> listCarts = (List<CartViewModel>) httpSession.getAttribute(CommonConstands.CART_SESSION);
			modelMap.addAttribute("quantityCart", listCarts.size());
			modelMap.addAttribute("itemCart", listCarts);
		}
		return "checkout";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/Api/AddCart")
	@ResponseBody
	public String AddCart(@ModelAttribute CartViewModel cartViewModel, HttpSession httpSession, ModelMap modelMap) {
		
		if(httpSession.getAttribute(CommonConstands.CART_SESSION) == null) {
			List<CartViewModel> cartViewModels = new ArrayList<CartViewModel>();
			cartViewModels.add(cartViewModel);
			httpSession.setAttribute(CommonConstands.CART_SESSION, cartViewModels);
			
			return cartViewModels.size() + "";
		}else {
			List<CartViewModel> listCarts = (List<CartViewModel>) httpSession.getAttribute(CommonConstands.CART_SESSION);
			int position = CheckItemCart(listCarts, cartViewModel.getId(), httpSession);
			if(position == -1) {
				listCarts.add(cartViewModel);
			}else {
				int newQuantity = listCarts.get(position).getQuantity() + 1;
				listCarts.get(position).setQuantity(newQuantity);
			}
			
			
			return listCarts.size() + "";
		}
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/Api/UpdateCart")
	@ResponseBody
	public void UpdateCart(HttpSession httpSession, @RequestParam int id, @RequestParam int quantity) {
		if(httpSession.getAttribute(CommonConstands.CART_SESSION) != null) {
			List<CartViewModel> listCarts = (List<CartViewModel>) httpSession.getAttribute(CommonConstands.CART_SESSION);
			int position = CheckItemCart(listCarts, id, httpSession);
			listCarts.get(position).setQuantity(quantity);
		}
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/Api/DeleteCart")
	@ResponseBody
	public void DeleteCart(HttpSession httpSession, @RequestParam int id) {
		if(httpSession.getAttribute(CommonConstands.CART_SESSION) != null) {
			List<CartViewModel> listCarts = (List<CartViewModel>) httpSession.getAttribute(CommonConstands.CART_SESSION);
			int position = CheckItemCart(listCarts, id, httpSession);
			listCarts.remove(position);
		}
	}
	
	
	private int CheckItemCart(List<CartViewModel> listCarts, int id, HttpSession httpSession) {
		for (int i = 0; i < listCarts.size(); i++) {
			if(listCarts.get(i).getId() == id) {
				return i;
			}
		}
		return -1;
	}
	
//	@RequestMapping(method = RequestMethod.GET, value = "/Api/TakeQuantityCart")
//	@ResponseBody
//	public String TakeQuantityCart(HttpSession httpSession) {
//		if(httpSession.getAttribute(CommonConstands.CART_SESSION) != null) {
//			List<CartViewModel> listCarts = (List<CartViewModel>) httpSession.getAttribute(CommonConstands.CART_SESSION);
//			return listCarts.size() + "";
//		}
//		return "";
//	}
}
