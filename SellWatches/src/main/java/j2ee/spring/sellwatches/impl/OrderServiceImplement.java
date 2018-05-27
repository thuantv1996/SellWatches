package j2ee.spring.sellwatches.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import j2ee.spring.sellwatches.dao.AccountDAO;
import j2ee.spring.sellwatches.dao.OrderDAO;
import j2ee.spring.sellwatches.models.Customer;
import j2ee.spring.sellwatches.models.Order;
import j2ee.spring.sellwatches.models.Product;
import j2ee.spring.sellwatches.services.MSSQLService;
import j2ee.spring.sellwatches.services.Orderservice;
import j2ee.spring.sellwatches.viewmodel.CartViewModel;
import j2ee.spring.sellwatches.viewmodel.InfoOrderViewModel;

@Component
public class OrderServiceImplement implements Orderservice, MSSQLService<Order> {

	@Autowired
	private  OrderDAO orderDAO; 
	
	public List<Order> getList() {
		return orderDAO.select();
	}

	public List<Order> select() {
		return orderDAO.select();
	}

	public boolean insert(Order t) {
		return orderDAO.insert(t);
	}

	public boolean update(Order t) {
		return orderDAO.update(t);
	}

	public boolean delete(Object[] idPara) {
		return orderDAO.delete(idPara);
	}

	public Order findById(Object[] idPara) {
		return orderDAO.findById(idPara);
	}
	
	public Customer findCustomByAccount(String userName) {
		return orderDAO.findCustomByAccount(userName);
	}
	
	public Product TakeQuantityProduct(int id) {
		return orderDAO.TakeQuantityProduct(id);
	}
	
	public Boolean UpdateQuantityProduct(int id, int quantity) {
		return orderDAO.UpdateQuantityProduct(id, quantity);
	}
}
