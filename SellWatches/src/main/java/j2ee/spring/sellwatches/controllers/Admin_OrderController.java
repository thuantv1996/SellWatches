package j2ee.spring.sellwatches.controllers;

import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;
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
import j2ee.spring.sellwatches.dao.HibernateUtil;
import j2ee.spring.sellwatches.impl.CustomerServiceImplement;
import j2ee.spring.sellwatches.impl.DetailInvoiceServiceImplement;
import j2ee.spring.sellwatches.impl.OrderServiceImplement;
import j2ee.spring.sellwatches.impl.ProductServiceImplement;
import j2ee.spring.sellwatches.models.Customer;
import j2ee.spring.sellwatches.models.DetailInvoice;
import j2ee.spring.sellwatches.models.DetailInvoiceID;
import j2ee.spring.sellwatches.models.Order;
import j2ee.spring.sellwatches.models.Product;
import j2ee.spring.sellwatches.viewmodel.DetailInvoiceProductViewModel;
import j2ee.spring.sellwatches.viewmodel.UpdateOrderViewModel;

@Component
@Controller
@SessionAttributes(CommonConstands.ADMIN_SESSION)
public class Admin_OrderController {
	
	@Autowired
	OrderServiceImplement orderServiceImplement;
	
	@Autowired
	ProductServiceImplement productServiceImplement;
	
	@Autowired
	CustomerServiceImplement customerServiceImplement;
	
	@Autowired
	DetailInvoiceServiceImplement detailInvoiceServiceImplement;
	
	@RequestMapping(value = "/admin/order", method = RequestMethod.GET)
	public String Default(ModelMap modelMap,HttpSession httpSession) {
		if(httpSession.getAttribute(CommonConstands.ADMIN_SESSION) == null) {
			return "redirect: login ";
		}
		int totalRecord = orderServiceImplement.select().size();
		int totalPage = (int) Math.ceil(((double)totalRecord/10));
		modelMap.addAttribute("totalPage", 10);
		
		List<Order> orders = orderServiceImplement.TakeListOrderLimit(0);
		modelMap.addAttribute("listOrders", orders);
		
		List<Product> products = productServiceImplement.select();
		modelMap.addAttribute("listProducts", products);
		
		return "admin_order";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/Api/TakeListOrderLimit", produces="text/plain; charset=utf-8")
	@ResponseBody
	public String TakeListOrderLimit(@RequestParam int pageIndex) {
		
		int startIndex = (pageIndex - 1) * 10;
		String html = "";
		
		NumberFormat formatter = new DecimalFormat("###,###");
        
		List<Order> listOrders = orderServiceImplement.TakeListOrderLimit(startIndex);
		for (Order order : listOrders) {
			html += "<tr>";
			html += "<td data-tennguoinhan='"+order.getCustomer().getName()+"'>"+order.getCustomer().getName()+"</td>";
			html += "<td data-sodt='"+order.getNumberPhone()+"'>"+order.getNumberPhone()+"</td>";
			html += "<td data-diachi='"+order.getDeliveryAddress()+"'>"+order.getDeliveryAddress()+"</td>";
			html += "<td data-tinhtrang='"+order.getStatus()+"'>"+order.getStatus()+"</td>";
			html += "<td data-ngaymua='"+order.getOrderDay()+"'>"+order.getOrderDay()+"</td>";
			html += "<td data-ngaygiao='"+order.getDeliveryDay()+"'>"+order.getDeliveryDay()+"</td>";
			html += "<td data-tongtien='"+(int)order.getAmount()+"'>"+formatter.format(order.getAmount())+" VNĐ</td>";
			html += "<td data-id='"+order.getId()+"' data-idCus='"+order.getCustomer().getId()+"'><a class='btn btn-success btn-capnhathoadon'>Cập nhật</a></td>";
			html += "</tr>";
		}
		
		return html;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/Api/LoadOrderDetail", produces="text/plain; charset=utf-8")
	@ResponseBody
	public String LoadOrderDetail(@RequestParam int id) {
		
		List<DetailInvoice> detailInvoices = new ArrayList<DetailInvoice>();
		List<Product> products = new ArrayList<Product>();
		DetailInvoiceProductViewModel detailInvoiceProductViewModel = new DetailInvoiceProductViewModel();
		

		String html = "";
		
		NumberFormat formatter = new DecimalFormat("###,###");
        
		List<Object[]> listObjects = orderServiceImplement.LoadOrderDetail(id);
		for (int i = 0; i < listObjects.size(); i++) {
			Object object[] = listObjects.get(i);
			detailInvoices.add((DetailInvoice) object[0]);
			products.add((Product) object[1]);
		}
		
		detailInvoiceProductViewModel.setDetailInvoices(detailInvoices);
		detailInvoiceProductViewModel.setProducts(products);
		
		for (int i = 0; i < listObjects.size(); i++) {
			html += "<tr>";
			html += "<th>";
			html += "Tên sản phẩm : <input disabled style='margin:5px; padding:5px; width:60%' data-masp='"+detailInvoiceProductViewModel.getProducts().get(i).getId()+"' name='mangsanpham[]' type="
					+ "text' value='"+detailInvoiceProductViewModel.getProducts().get(i).getNameProduct()+"' />";
            html += "</th>";

            html += "<th>";
            html += "Số lượng : <input disabled data-masp='"+detailInvoiceProductViewModel.getProducts().get(i).getId()+"' style='margin:5px; padding:5px; width:60%' name='mangsoluong[]' type='text' value='"+detailInvoiceProductViewModel.getDetailInvoices().get(i).getQuantity()+"' />";
            html += "<a class='btn btn-danger btnxoachitiethoadon'>Xóa</a>";
            html += "</th>";
            html += "</tr>";
		}
		
		return html;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/Api/UpdateOrder", produces="text/plain; charset=utf-8")
	@ResponseBody
	public String UpdateOrder(@ModelAttribute UpdateOrderViewModel updateOrderViewModel) {
		//xử lý số lượng đặt không được vượt quá tồn kho
		int count = updateOrderViewModel.getMangmasp().length;
		boolean kiemtra = false;
		String chuoithongbao = "";
		
		for (int i = 0; i < count; i++) {
			int masp = updateOrderViewModel.getMangmasp()[i];
			int soluong = updateOrderViewModel.getMangsoluong()[i];
			String tensp = updateOrderViewModel.getMangtensp()[i];
			
			int soluongtonkho = productServiceImplement.TakeQuantityProduct(masp);
			
			if(soluongtonkho < soluong) {
				chuoithongbao += "Quá số lượng tồn kho: " 
						+ "Tên sản phẩm: '"+tensp+"' # Số lượng: '"+(soluongtonkho - soluong)+"'"; 
				kiemtra = true;
			}
		}
		
		//xử lý tiếp khi thỏa mãn số lượng tồn kho
		if(!kiemtra) {
			Object idOrder[] = {updateOrderViewModel.getMahd()};
			Order order = orderServiceImplement.findById(idOrder);
			
			//cập nhập khách hàng trong hóa đơn
			customerServiceImplement.updateByPara(updateOrderViewModel, order.getCustomer().getId());
			
			//Tính lại tổng tiền hóa đơn kèm theo giá khuyến mãi nếu có
			float totalMoney = 0;
			for (int i = 0; i < count; i++) { 
				int masp = updateOrderViewModel.getMangmasp()[i];
				int soluong = updateOrderViewModel.getMangsoluong()[i];
				
				//Lấy ra phần trăm khuyến mãi của sản phẩm nếu có
				int phantramkm = productServiceImplement.GetPromotion(masp);
				
				Object idPro[] = {masp};
				Product product = productServiceImplement.findById(idPro);
				totalMoney +=  soluong * product.getPrice() * ((float)(100 - phantramkm) / 100); 
			}
			
			//Tiến hành cập nhập hóa đơn và chi tiết hóa đơn
			if(updateOrderViewModel.getTinhtrang().equals("chờ kiểm duyệt") || updateOrderViewModel.getTinhtrang().equals("hoàn thành")) {		
				orderServiceImplement.UpdateOrderByPara(updateOrderViewModel, totalMoney);
				detailInvoiceServiceImplement.DeleteByID(updateOrderViewModel.getMahd());
				
				for(int i = 0; i < count; i++) {
					int masp = updateOrderViewModel.getMangmasp()[i];
					int soluong = updateOrderViewModel.getMangsoluong()[i];
					
					DetailInvoiceID detailInvoiceID = new DetailInvoiceID();
					detailInvoiceID.setOrderId(updateOrderViewModel.getMahd());
					detailInvoiceID.setProductId(masp);
					
					DetailInvoice detailInvoice = new DetailInvoice();
					detailInvoice.setDetailInvoiceID(detailInvoiceID);
					detailInvoice.setQuantity(soluong);
					
					detailInvoiceServiceImplement.insert(detailInvoice);
				}
				chuoithongbao = "Cập nhập thành công";
			}else if (updateOrderViewModel.getTinhtrang().equals("đã hủy")) {
				orderServiceImplement.UpdateOrderByPara(updateOrderViewModel, totalMoney);
				for(int i = 0; i < count; i++) {
					int masp = updateOrderViewModel.getMangmasp()[i];
					int soluong = updateOrderViewModel.getMangsoluong()[i];
					
					boolean checkUpdateQuantityProduct = productServiceImplement.UpdateQuantityProduct(masp, soluong, true);
					if(!checkUpdateQuantityProduct) {
						return "Cập nhập số lượng sản phẩm thất bại";
					}
				}
				chuoithongbao = "Cập nhập thành công";
			}else if (updateOrderViewModel.getTinhtrang().equals("đang giao hàng")) {
				orderServiceImplement.UpdateOrderByPara(updateOrderViewModel, totalMoney);
				for(int i = 0; i < count; i++) {
					int masp = updateOrderViewModel.getMangmasp()[i];
					int soluong = updateOrderViewModel.getMangsoluong()[i];
					
					boolean checkUpdateQuantityProduct = productServiceImplement.UpdateQuantityProduct(masp, soluong, false);
					if(!checkUpdateQuantityProduct) {
						return "Cập nhập số lượng sản phẩm thất bại";
					}
				}
				chuoithongbao = "Cập nhập thành công";
			}
		}
			
		return chuoithongbao;
	}
}
