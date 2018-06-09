package j2ee.spring.sellwatches.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import j2ee.spring.sellwatches.dao.CustomerDAO;
import j2ee.spring.sellwatches.models.Customer;
import j2ee.spring.sellwatches.services.MSSQLService;

@Component
public class CustomerServiceImplement implements MSSQLService<Customer>{

	@Autowired
	CustomerDAO customerDAO;
	
	public List<Customer> select() {
		return customerDAO.select();
	}

	public boolean insert(Customer t) {
		return customerDAO.insert(t);
	}

	public boolean update(Customer t) {
		return customerDAO.update(t);
	}

	public boolean delete(Object[] idPara) {
		return customerDAO.delete(idPara);
	}

	public Customer findById(Object[] idPara) {
		return customerDAO.findById(idPara);
	}

}
