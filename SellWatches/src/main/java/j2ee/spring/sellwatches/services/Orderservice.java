package j2ee.spring.sellwatches.services;

import java.util.List;

import j2ee.spring.sellwatches.models.Order;
import j2ee.spring.sellwatches.viewmodel.UpdateOrderViewModel;

public interface Orderservice {
	List<Order> getList();
	List<Order> TakeListOrderLimit(int firstOrder);
	List<Object[]> LoadOrderDetail(int mahd);
	Boolean UpdateOrderByPara(UpdateOrderViewModel updateOrderViewModel, float totalMoney);
}
