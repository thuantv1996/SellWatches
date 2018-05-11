package j2ee.spring.sellwatches.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import j2ee.spring.sellwatches.dao.AccountDAO;
import j2ee.spring.sellwatches.models.Account;
import j2ee.spring.sellwatches.services.AccountService;
import j2ee.spring.sellwatches.services.MSSQLService;

@Component
public class AccountServiceImplement implements AccountService,MSSQLService<Account>{

	@Autowired
	private AccountDAO accountDAO; 
	
	public List<Account> getList() {
		return accountDAO.Select();
	}

	
	public List<Account> select() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean insert(Account t) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean update(Account t) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean delete(Object[] idPara) {
		// TODO Auto-generated method stub
		return false;
	}

	public Account findById(Object[] idPara) {
		// TODO Auto-generated method stub
		return null;
	}

}
