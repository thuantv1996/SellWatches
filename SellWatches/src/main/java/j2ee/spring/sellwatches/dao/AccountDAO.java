package j2ee.spring.sellwatches.dao;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import j2ee.spring.sellwatches.common.Encryptor;
import j2ee.spring.sellwatches.models.Account;
import j2ee.spring.sellwatches.models.Customer;
import j2ee.spring.sellwatches.models.TypeAccount;
import j2ee.spring.sellwatches.viewmodel.RegisterViewModel;

@Repository
public class AccountDAO {

	private Session session;

	public List<Account> select() {
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.getTransaction().begin();
			@SuppressWarnings("unchecked")
			List<Account> res = session.createQuery("from Account").getResultList();
			session.getTransaction().commit();
			return res;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			return null;
		}
	}

	public boolean update(Account t) {
		if (t == null) {
			return false;
		}
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.getTransaction().begin();
			session.update(t);
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			return false;
		}
	}

	public boolean insert(Account t) {
		if (t == null) {
			return false;
		}
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.getTransaction().begin();
			session.save(t);
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			return false;
		}
	}

	public boolean delete(Object[] idPara) {
		if (idPara.length == 0) {
			return false;
		}
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.getTransaction().begin();
			Query query = session.createQuery("delete Account where id = :id");
			query.setParameter("id", idPara[0]);
			int result = query.executeUpdate();
			if (result > 0) {
				// write log
				System.out.println("Rows affected: " + result);
			}
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			return false;
		}
	}

	public Account findById(Object[] idPara) {
		if (idPara.length == 0) {
			return null;
		}
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.getTransaction().begin();
			Query query = session.createQuery("from Account where id = :id");
			query.setParameter("id", idPara[0]);
			@SuppressWarnings("unchecked")
			List<Account> result = query.getResultList();
			if (result.size() > 0) {
				// write log
				System.out.println("find excute!");
			}
			session.getTransaction().commit();
			return result.get(0);
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			return null;
		}
	}
	
	public Account findByUserName(String userName) {
		if (userName.length() == 0) {
			return null;
		}
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.getTransaction().begin();
			Query query = session.createQuery("from Account where userName = :id");
			query.setParameter("id", userName);
			@SuppressWarnings("unchecked")
			List<Account> result = query.getResultList();
			if (result.size() > 0) {
				// write log
				System.out.println("find excute!");
			}
			session.getTransaction().commit();
			return result.get(0);
		} catch (Exception e) {
			e.printStackTrace();
//			session.getTransaction().rollback();
			return null;
		}
	}
	
	public Boolean RegisterAccount(RegisterViewModel registerViewModel) {
		if (registerViewModel == null) {
			return false;
		}
		TypeAccountDAO typeAccountDAO = new TypeAccountDAO();
		Object idPara[] = {"LK00002"};
		
		TypeAccount typeAccount = new TypeAccount();
		typeAccount = typeAccountDAO.findById(idPara);
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.getTransaction().begin();
			
//			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			
			Account account = new Account();
			account.setUserName(registerViewModel.getUserName());
			account.setPassword(Encryptor.MD5Hash(registerViewModel.getPassWord()));
			account.setRegisterDay(timestamp);
			account.setStatus(1);
			account.setTypeAccount(typeAccount);
			
			Customer customer = new Customer();
			customer.setName(registerViewModel.getFirstName() + " " + registerViewModel.getLastName());
			customer.setEmail(registerViewModel.getEmail());
			customer.setAddress(registerViewModel.getAddress());
			customer.setNumberPhone(registerViewModel.getNumberPhone());
			customer.setSex(registerViewModel.getSex());
			customer.setAccount(account);
			
			session.save(customer);
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			return false;
		}
	}
	
	public boolean isExistAccount(String userName)
	{
		Account account = new Account();
		account = findByUserName(userName);
		if(account != null)
		{
			return true;
		}
		return false;
	}
	
	public Boolean LoginAccount(String userName, String passWord)
	{
		if (userName.length() == 0 || passWord.length() == 0) {
			return false;
		}
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.getTransaction().begin();
			Account account = (Account)session.createQuery("from Account where userName='"+userName+"' and passWord='"+passWord+"'").getSingleResult();
			session.getTransaction().commit();
			if(account != null) {
				return true;
			}else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
