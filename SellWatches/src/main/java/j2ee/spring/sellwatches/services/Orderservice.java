package j2ee.spring.sellwatches.services;

import java.util.List;

import j2ee.spring.sellwatches.models.Order;

public interface Orderservice {
	List<Order> getList();
}
