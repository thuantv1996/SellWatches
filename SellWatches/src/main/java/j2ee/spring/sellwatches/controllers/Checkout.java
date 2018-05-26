package j2ee.spring.sellwatches.controllers;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
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
import j2ee.spring.sellwatches.dao.AccountDAO;
import j2ee.spring.sellwatches.impl.DetailInvoiceServiceImplement;
import j2ee.spring.sellwatches.impl.OrderServiceImplement;
import j2ee.spring.sellwatches.models.Account;
import j2ee.spring.sellwatches.models.Customer;
import j2ee.spring.sellwatches.models.DetailInvoice;
import j2ee.spring.sellwatches.models.DetailInvoiceID;
import j2ee.spring.sellwatches.models.Order;
import j2ee.spring.sellwatches.viewmodel.CartViewModel;
import j2ee.spring.sellwatches.viewmodel.InfoOrderViewModel;

@Controller
@Component
@SessionAttributes({CommonConstands.CART_SESSION, CommonConstands.USER_SESSION})
public class Checkout {
	
	@Autowired
	OrderServiceImplement orderServiceImplement;
	
	@Autowired
	DetailInvoiceServiceImplement detailInvoiceServiceImplement;
	
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
	
	@RequestMapping(method = RequestMethod.POST, value = "/Checkout")
	public String AddOrder(@ModelAttribute InfoOrderViewModel infoOrderViewModel, HttpSession httpSession, ModelMap modelMap) {
		
		if(httpSession.getAttribute(CommonConstands.USER_SESSION) == null && httpSession.getAttribute(CommonConstands.CART_SESSION) != null) {
			List<CartViewModel> listCarts = (List<CartViewModel>) httpSession.getAttribute(CommonConstands.CART_SESSION);
			
			//Tính tổng tiền hóa đơn
			int totalCart = 0;
			for (CartViewModel listItemCart : listCarts) {
				totalCart += listItemCart.getQuantity() * listItemCart.getPrice();
			}
			
			AccountDAO accountDAO = new AccountDAO();
			Account account = new Account();
			account = accountDAO.findByUserName("userdefault");
			
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			
			Customer customer = new Customer();
			customer.setAccount(account);
			customer.setName(infoOrderViewModel.getFullName());
			customer.setEmail(infoOrderViewModel.getEmail());
			customer.setAddress(infoOrderViewModel.getAddress());
			customer.setNumberPhone(infoOrderViewModel.getPhoneNumber());
			customer.setSex(null);
			
			//Ngày giao bằng ngày hiện tại + 3
			Timestamp tempTimestamp = timestamp;
			Calendar cal = Calendar.getInstance();
			cal.setTime(tempTimestamp);
			cal.add(Calendar.DAY_OF_WEEK, 3);
			tempTimestamp.setTime(cal.getTime().getTime());
			
			Order order = new Order();
			order.setCustomer(customer);
			order.setStatus("Chưa giao");
			order.setDeliveryAddress(infoOrderViewModel.getAddress());
			order.setNumberPhone(infoOrderViewModel.getPhoneNumber());
			order.setOrderDay(timestamp);
			order.setDeliveryDay(tempTimestamp);
			order.setAmount(totalCart);
			order.setDescribe(infoOrderViewModel.getDescribe());
			
			boolean checkOrder = orderServiceImplement.insert(order);
			if(checkOrder) {
				for (CartViewModel listItemCart : listCarts) {
					DetailInvoiceID detailInvoiceID = new DetailInvoiceID();
					detailInvoiceID.setOrderId(order.getId());
					detailInvoiceID.setProductId(listItemCart.getId());
					
					DetailInvoice detailInvoice = new DetailInvoice();
					detailInvoice.setDetailInvoiceID(detailInvoiceID);
					detailInvoice.setQuantity(listItemCart.getQuantity());
					
					boolean checkSuccess = detailInvoiceServiceImplement.insert(detailInvoice);
					if(checkSuccess) {
						modelMap.addAttribute("checkOrderCart", "Thanh toán thành công");
					}else {
						modelMap.addAttribute("checkOrderCart", "Thanh toán thất bại");
					}
				}
			}else {
				modelMap.addAttribute("checkOrderCart", "Thanh toán thất bại");
			}
		}
		
		return "checkout";
	}
	
}
