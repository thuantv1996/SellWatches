package j2ee.spring.sellwatches.dao;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import javax.persistence.Query;

import org.hibernate.Session;
import org.springframework.stereotype.Component;

import j2ee.spring.sellwatches.models.Product;
import j2ee.spring.sellwatches.models.Promotion;

@Component
public class ProductDAO {
	
	
	private Session session;

	public List<Product> select() {
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.getTransaction().begin();
			@SuppressWarnings("unchecked")
			List<Product> res = session.createQuery("from Product").getResultList();
			session.getTransaction().commit();
			return res;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			return null;
		}
	}

	public boolean insert(Product t) {
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

	public boolean update(Product t) {
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
			Query query = session.createQuery("delete Product where id = :id");
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

	public Product findById(Object[] idPara) {
		if (idPara.length == 0) {
			return null;
		}
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.getTransaction().begin();
			Query query = session.createQuery("from Product where id = :id");
			query.setParameter("id", idPara[0]);
			@SuppressWarnings("unchecked")
			List<Product> result = query.getResultList();
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

	public int count() {
		List<Product> lstProduct = select();
		if (lstProduct == null) {
			return 0;
		}
		return lstProduct.size();
	}

	public List<Product> getListSellProduct() {
		// lấy ra danh sách sản phẩm trong danh sách hóa đơn
		String hql = "SELECT pd.id, SUM(di.quantity) FROM DetailInvoice di JOIN di.product pd "+
					"GROUP BY pd.id "+
					"ORDER BY Sum(di.quantity) DESC";
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.getTransaction().begin();
			Query query = session.createQuery(hql);
			List<?> result = query.getResultList();
			List<Product> lProduct = new ArrayList<Product>();
			for(int i=0; i<result.size(); i++) {
				Object obj = ((Object[])result.get(i))[0];
				query = session.createQuery("from Product where id = :id");
				query.setParameter("id", obj);
				@SuppressWarnings("unchecked")
				List<Product> res = query.getResultList();
				Product item = res.get(0);
				lProduct.add(item);
			}
			session.getTransaction().commit();
			return lProduct;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			return null;
		}
	}

	public List<Product> select(String string) {
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.getTransaction().begin();
			@SuppressWarnings("unchecked")
			List<Product> res = session.createQuery("from Product p ORDER BY p.id "+ string).getResultList();
			session.getTransaction().commit();
			return res;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			return null;
		}
	}

	public int getPromotion(int idProduct) {
		// Lấy danh sách promotion phù hợp
		PromotionDAO promotionDAO = new PromotionDAO();
		List<Promotion> promotions  = promotionDAO.findNow();
		// Tìm danh sách chi tiết
		
		// Lấy ra khuyến mãi cao nhất
		return 0;
	}
}
