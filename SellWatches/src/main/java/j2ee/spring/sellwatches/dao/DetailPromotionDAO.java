package j2ee.spring.sellwatches.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.springframework.stereotype.Component;

import j2ee.spring.sellwatches.models.DetailPromotion;
import j2ee.spring.sellwatches.models.Product;
import j2ee.spring.sellwatches.viewmodel.DetailPromotionViewModel;

@Component
public class DetailPromotionDAO {
	private Session session;

	public List<DetailPromotion> select() {
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.getTransaction().begin();
			@SuppressWarnings("unchecked")
			List<DetailPromotion> res = session.createQuery("from DetailPromotion").getResultList();
			session.getTransaction().commit();
			return res;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			return null;
		}
	}

	public boolean insert(DetailPromotion t) {
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

	public boolean update(DetailPromotion t) {
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
			Query query = session.createQuery("delete DetailPromotion where detailPromotionID.promotion = :promotion and detailPromotionID.product = :product");
			query.setParameter("promotion", idPara[0]);
			query.setParameter("product", idPara[1]);
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

	public DetailPromotion findById(Object[] idPara) {
		if (idPara.length == 0) {
			return null;
		}
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.getTransaction().begin();
			Query query = session.createQuery("from DetailPromotion where detailPromotionID.promotion = :promotion and detailPromotionID.product = :product");
			query.setParameter("promotion", idPara[0]);
			query.setParameter("product", idPara[1]);
			@SuppressWarnings("unchecked")
			List<DetailPromotion> result = query.getResultList();
			session.getTransaction().commit();
			if (result.size() > 0) {
				// write log
				System.out.println("find excute!");
				return result.get(0);
			}
			else
				return null;
			
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			return null;
		}
	}
	public List<DetailPromotion> findById(Product product) {
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.getTransaction().begin();
			Query query = session.createQuery("from DetailPromotion where detailPromotionID.product = :product");
			query.setParameter("product", product.getId());
			@SuppressWarnings("unchecked")
			List<DetailPromotion> result = query.getResultList();
			if (result.size() > 0) {
				// write log
				System.out.println("find excute!");
			}
			session.getTransaction().commit();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			return null;
		}
	}

	public List<DetailPromotion> findByIdPromotion(String id) {
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.getTransaction().begin();
			Query query = session.createQuery("from DetailPromotion where detailPromotionID.promotion = :id");
			query.setParameter("id", id);
			@SuppressWarnings("unchecked")
			List<DetailPromotion> result = query.getResultList();
			if (result.size() > 0) {
				// write log
				System.out.println("find excute!");
			}
			session.getTransaction().commit();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			return new ArrayList<>();
		}
	}

	public List<DetailPromotionViewModel> getList(String id) {
		List<DetailPromotionViewModel> res = new ArrayList<>();
		List<DetailPromotion> detais = new ArrayList<>();
		detais = findByIdPromotion(id);
		ProductDAO productDAO = new ProductDAO();
		for (DetailPromotion detailPromotion : detais) {
			DetailPromotionViewModel item = new DetailPromotionViewModel();
			item.setIdPromotion(detailPromotion.getDetailPromotionID().getPromotion());
			item.setIdProduct(detailPromotion.getDetailPromotionID().getProduct());
			item.setContent(detailPromotion.getContent());
			Object[] idPara = {detailPromotion.getDetailPromotionID().getProduct()};
			item.setProduct(productDAO.findById(idPara));
			res.add(item);
		}
		return res;
	}
}
