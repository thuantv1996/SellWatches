package j2ee.spring.sellwatches.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.springframework.stereotype.Component;

import j2ee.spring.sellwatches.models.Account;
import j2ee.spring.sellwatches.models.Category;

@Component
public class CategoryDAO {

	private Session session;
	
	public List<Category> select() {
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.getTransaction().begin();
			@SuppressWarnings("unchecked")
			List<Category> res = session.createQuery("from Category").getResultList();
			session.getTransaction().commit();
			return res;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			return null;
		}
	}

	public boolean insert(Category t) {
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

	public boolean update(Category t) {
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

	public boolean delete(Object[] idPara) {
		if (idPara.length == 0) {
			return false;
		}
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.getTransaction().begin();
			Query query = session.createQuery("delete Category where id = :id");
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

	public Category findById(Object[] idPara) {
		if (idPara.length == 0) {
			return null;
		}
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.getTransaction().begin();
			Query query = session.createQuery("from Category where id = :id");
			query.setParameter("id", idPara[0]);
			@SuppressWarnings("unchecked")
			List<Category> result = query.getResultList();
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
}
