package j2ee.spring.sellwatches.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import j2ee.spring.sellwatches.dao.AccountDAO;
import j2ee.spring.sellwatches.models.Account;
import j2ee.spring.sellwatches.services.AccountService;

@Component
public class AccountServiceImplement implements AccountService{

	@Autowired
	private AccountDAO accountDAO; 
	
	public List<Account> getList() {
		return accountDAO.Select();
	}

}
