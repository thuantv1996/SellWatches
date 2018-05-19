package j2ee.spring.sellwatches.impl;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.type.filter.RegexPatternTypeFilter;
import org.springframework.stereotype.Component;

import j2ee.spring.sellwatches.dao.AccountDAO;
import j2ee.spring.sellwatches.dao.CustomerDAO;
import j2ee.spring.sellwatches.dao.HibernateUtil;
import j2ee.spring.sellwatches.dao.TypeAccountDAO;
import j2ee.spring.sellwatches.models.Account;
import j2ee.spring.sellwatches.models.Customer;
import j2ee.spring.sellwatches.models.TypeAccount;
import j2ee.spring.sellwatches.services.AccountService;
import j2ee.spring.sellwatches.services.MSSQLService;
import j2ee.spring.sellwatches.viewmodel.RegisterViewModel;

@Component
public class AccountServiceImplement implements AccountService {

	@Autowired
	private AccountDAO accountDAO;
	
	@Autowired
	private TypeAccountDAO typeAccountDAO;
	
	private Session session;

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

	public Boolean RegisterAccount(RegisterViewModel registerViewModel) {
		return accountDAO.RegisterAccount(registerViewModel);
	}
	
	
	public static final Pattern VALID_PASSWORD_REGEX = 
			Pattern.compile("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$", Pattern.CASE_INSENSITIVE);

	public boolean isValidPassword(String passWord) {
        Matcher matcher = VALID_PASSWORD_REGEX.matcher(passWord);
        return matcher.find();
	}

	public static final Pattern VALID_EMAIL_ADDRESS_REGEX = 
			Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

	public boolean isValidEmail(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
        return matcher.find();
	}

	public Boolean isExistAccount(String userName) {
		return accountDAO.isExistAccount(userName);
	}

	public Boolean LoginAccount(String userName, String passWord) {
		return accountDAO.LoginAccount(userName, passWord);
	}
	
}
