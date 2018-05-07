package j2ee.spring.sellwatches.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import j2ee.spring.sellwatches.models.Account;

@Repository
public class AccountDAO {

	
	private Session session;
	
	public List<Account> Select() {
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

}
