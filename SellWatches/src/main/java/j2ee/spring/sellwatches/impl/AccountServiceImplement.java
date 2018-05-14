package j2ee.spring.sellwatches.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import j2ee.spring.sellwatches.dao.AccountDAO;
import j2ee.spring.sellwatches.models.Account;
import j2ee.spring.sellwatches.services.AccountService;
import j2ee.spring.sellwatches.services.MSSQLService;

@Component
public class AccountServiceImplement implements AccountService {

	@Autowired
	private AccountDAO accountDAO;

	public List<Account> select() {
		return accountDAO.select();
	}

	public boolean insert(Account t) {
		return accountDAO.insert(t);
	}

	public boolean update(Account t) {
		return accountDAO.update(t);
	}

	public boolean delete(Object[] idPara) {
		return accountDAO.delete(idPara);
	}

	public Account findById(Object[] idPara) {
		return accountDAO.findById(idPara);
	}

}
