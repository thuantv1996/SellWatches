package j2ee.spring.sellwatches.dao;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.TemporalType;

import org.hibernate.Session;
import org.springframework.stereotype.Component;

import j2ee.spring.sellwatches.models.Promotion;
import j2ee.spring.sellwatches.services.MSSQLService;

@Component
public class PromotionDAO{
	private Session session;
	
	public List<Promotion> select() {
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.getTransaction().begin();
			@SuppressWarnings("unchecked")
			List<Promotion> res = session.createQuery("from Promotion").getResultList();
			session.getTransaction().commit();
			return res;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			return null;
		}
	}

	public boolean insert(Promotion t) {
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

	public boolean update(Promotion t) {
		if (t == null) {
			return false;
		}
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.getTransaction().begin();
			Query query = session.createQuery("update Promotion set namePromotion = :namePromotion, beginDay = :beginDay,"
					+ " endDay = :endDay where id = :id");
			query.setParameter("id", t.getId());
			query.setParameter("namePromotion", t.getNamePromotion());
			query.setParameter("beginDay", t.getBeginDay(),TemporalType.TIMESTAMP);
			query.setParameter("endDay", t.getEndDay(),TemporalType.TIMESTAMP);
			query.executeUpdate();
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
			Query query = session.createQuery("delete Promotion where id = :id");
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

	public Promotion findById(Object[] idPara) {
		if (idPara.length == 0) {
			return null;
		}
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.getTransaction().begin();
			Query query = session.createQuery("from Promotion where id = :id");
			query.setParameter("id", idPara[0]);
			@SuppressWarnings("unchecked")
			List<Promotion> result = query.getResultList();
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

	public List<Promotion> findNow() {
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		Timestamp curTime = new Timestamp(System.currentTimeMillis());
		try {
			session.getTransaction().begin();
			Query query = session.createQuery("from Promotion WHERE beginDay <= :curTime and endDay >= :curTime");
			query.setParameter("curTime", curTime);
			@SuppressWarnings("unchecked")
			List<Promotion> res = query.getResultList();
			session.getTransaction().commit();
			return res;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			return null;
		}
	}

	public List<Promotion> getListDES() {
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.getTransaction().begin();
			@SuppressWarnings("unchecked")
			List<Promotion> res = session.createQuery("from Promotion p ORDER BY p.beginDay DESC ").getResultList();
			session.getTransaction().commit();
			return res;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			return null;
		}
	}

	public String getMaxId() {
		try {
			return getListDES().get(0).getId();
		}catch(Exception e)
		{
			return "KM00000";
		}
		
	}

}
