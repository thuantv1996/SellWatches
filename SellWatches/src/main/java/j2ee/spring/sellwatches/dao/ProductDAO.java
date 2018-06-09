package j2ee.spring.sellwatches.dao;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import javax.persistence.Query;
import javax.persistence.TemporalType;

import org.hibernate.Session;
import org.springframework.stereotype.Component;

import j2ee.spring.sellwatches.models.DetailPromotion;
import j2ee.spring.sellwatches.models.Product;
import j2ee.spring.sellwatches.models.Promotion;
import j2ee.spring.sellwatches.models.Trademark;

@Component
public class ProductDAO {
	private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
	
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
		DetailPromotionDAO detailPromotionsDAO = new DetailPromotionDAO();
		Product product= new Product();
		product.setId(idProduct);
		List<DetailPromotion> detailPromotions = detailPromotionsDAO.findById(product);
		int maxContent = 0 ;
		for (DetailPromotion detailPromotion : detailPromotions) {
			// Kiem tra ngay bat dau va ket thuc
			Timestamp current = new Timestamp(System.currentTimeMillis());
			if(detailPromotion.getPromotion().getBeginDay().before(current) && 
					detailPromotion.getPromotion().getEndDay().after(current))
			{
				// kiem tra phan tram khuyen mai
				if(detailPromotion.getContent()>maxContent)
				{
					maxContent = detailPromotion.getContent();
				}
			}
		}
		return maxContent;
	}

	public List<Product> select(Trademark trademark) {
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.getTransaction().begin();
			Query query = session.createQuery("from Product where trademark = :trademark");
			query.setParameter("trademark", trademark);
			@SuppressWarnings("unchecked")
			List<Product> result = query.getResultList();
			session.getTransaction().commit();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			return null;
		}
	}
	
	public List<Product> LoadProductAll() {
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.getTransaction().begin();
			@SuppressWarnings("unchecked")
			List<Product> res = session.createQuery("from Product order by id DESC").getResultList();
			session.getTransaction().commit();
			return res;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			return null;
		}
	}
	
	public List<Product> LoadProductMen() {
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.getTransaction().begin();
			@SuppressWarnings("unchecked")
			List<Product> res = session.createQuery("from Product p where p.category.id = 'LP00001' order by p.id DESC").getResultList();
			session.getTransaction().commit();
			return res;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			return null;
		}
	}
	
	public List<Product> LoadProductWomen() {
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.getTransaction().begin();
			@SuppressWarnings("unchecked")
			List<Product> res = session.createQuery("from Product p where p.category.id = 'LP00002' order by p.id DESC").getResultList();
			session.getTransaction().commit();
			return res;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			return null;
		}
	}

	public List<Product> getListProductWithKey(String key) {
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.getTransaction().begin();
			Query query = session.createQuery("from Product where nameProduct like :key");
			query.setParameter("key", "%"+key+"%");
			@SuppressWarnings("unchecked")
			List<Product> result = query.getResultList();
			session.getTransaction().commit();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			return null;
		}
	}
	
	public int GetPromotion(int id) {
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		int PHANTRAMKM = 0;
		try {
			session.getTransaction().begin();
			Timestamp toDay = new Timestamp(System.currentTimeMillis());
			Query query = session.createQuery("select ctkm.content from Promotion km, DetailPromotion ctkm where km.id = ctkm.promotion.id and ctkm.product.id = :id and km.beginDay <= km.endDay and km.endDay >= :toDay");
			query.setParameter("id", id);
			query.setParameter("toDay", toDay, TemporalType.TIMESTAMP);
			List<Integer> result = query.getResultList();
			if (result.size() > 0) {
				PHANTRAMKM = Collections.max(result);
				// write log
				System.out.println("find excute!");
			}
			session.getTransaction().commit();
			return PHANTRAMKM;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			return 0;
		}
	}
	
	//lấy số lượng tồn kho và xử lý cộng trừ
	public int HandleQuantityProduct(int masp, int soluong, Boolean kiemtra) {
		Object[] idPara = {masp};
		Product product = findById(idPara);
		int soluongtonkho = product.getNumber();
		if(kiemtra) {
			soluongtonkho += soluong;
		}else {
			soluongtonkho -= soluong;
		}
		return soluongtonkho;
	}
	
	public Boolean UpdateQuantityProduct(int masp, int soluong, Boolean kiemtra) {
		int soluongmoi = HandleQuantityProduct(masp, soluong, kiemtra);
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.getTransaction().begin();
			Query query = session.createQuery("update Product set number= :number where id= :id");
			query.setParameter("number", soluongmoi);
			query.setParameter("id", masp);
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
}
