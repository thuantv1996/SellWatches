package j2ee.spring.sellwatches.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import j2ee.spring.sellwatches.dao.AccountDAO;
import j2ee.spring.sellwatches.dao.OrderDAO;
import j2ee.spring.sellwatches.models.Order;
import j2ee.spring.sellwatches.services.MSSQLService;
import j2ee.spring.sellwatches.services.Orderservice;

@Component
public class OrderServiceImplement implements Orderservice, MSSQLService<Order> {

	@Autowired
	private  OrderDAO orderDAO; 
	
	public List<Order> getList() {
		return orderDAO.Select();
	}

	public List<Order> select() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean insert(Order t) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean update(Order t) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean delete(Object[] idPara) {
		// TODO Auto-generated method stub
		return false;
	}

	public Order findById(Object[] idPara) {
		// TODO Auto-generated method stub
		return null;
	}

}
