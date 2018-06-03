package j2ee.spring.sellwatches.dao;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.TemporalType;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import j2ee.spring.sellwatches.models.Customer;
import j2ee.spring.sellwatches.models.Order;
import j2ee.spring.sellwatches.models.Product;
import j2ee.spring.sellwatches.viewmodel.UpdateOrderViewModel;

@Repository
public class OrderDAO{

	private Session session;
	
	public List<Order> select() {
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.getTransaction().begin();
			@SuppressWarnings("unchecked")
			List<Order> res = session.createQuery("from Order").getResultList();
			session.getTransaction().commit();
			return res;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			return null;
		}
	}

	public boolean insert(Order t) {
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

	public boolean update(Order t) {
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
			Query query = session.createQuery("delete Order where id = :id");
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

	public Order findById(Object[] idPara) {
		if (idPara.length == 0) {
			return null;
		}
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.getTransaction().begin();
			Query query = session.createQuery("from Order where id = :id");
			query.setParameter("id", idPara[0]);
			@SuppressWarnings("unchecked")
			List<Order> result = query.getResultList();
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
	
	public Customer findCustomByAccount(String userName) {
		if (userName.length() == 0) {
			return null;
		}
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.getTransaction().begin();
			Query query = session.createQuery("from Customer c where c.account.id in(select tk.id from Account tk where tk.userName = :id)");
			query.setParameter("id", userName);
			@SuppressWarnings("unchecked")
			List<Customer> result = query.getResultList();
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
	
	public Product TakeQuantityProduct(int id) {
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.getTransaction().begin();
			Query query = session.createQuery("from Product p where p.id = :id");
			query.setParameter("id", id);
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
//			session.getTransaction().rollback();
			return null;
		}
	}
	
	public boolean UpdateQuantityProduct(int id, int quantity) {
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.getTransaction().begin();
			Query query = session.createQuery("update Product set number = :quantity where id = :id");
			query.setParameter("id", id);
			query.setParameter("quantity", quantity);
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
	
	public List<Order> TakeListOrderLimit(int firstOrder) {
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.getTransaction().begin();
			Query query = session.createQuery("from Order o order by o.id DESC");
			@SuppressWarnings("unchecked")
			List<Order> result = query.getResultList();
			int countResult = result.size();
			if (result.size() > 0) {
				// write log
				System.out.println("find excute!");
			}
			session.getTransaction().commit();
			return result.subList(Math.min(firstOrder, countResult), Math.min(countResult, firstOrder + 10));
		} catch (Exception e) {
			e.printStackTrace();
//			session.getTransaction().rollback();
			return null;
		}
	}
	
	public List<Object[]> LoadOrderDetail(int mahd) {
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.getTransaction().begin();
			Query query = session.createQuery("select cthd, sp from DetailInvoice cthd, Product sp WHERE cthd.detailInvoiceID.productId = sp.id and cthd.detailInvoiceID.orderId= :mahd");
			query.setParameter("mahd", mahd);
			@SuppressWarnings("unchecked")
			List<Object[]> result = query.getResultList();
			
			if (result.size() > 0) {
				// write log
				System.out.println("find excute!");
			}
			session.getTransaction().commit();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
//			session.getTransaction().rollback();
			return null;
		}
	}
	
	public Boolean UpdateOrderByPara(UpdateOrderViewModel updateOrderViewModel, float totalMoney) {
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.getTransaction().begin();
			Query query = session.createQuery("update Order set status= :status, deliveryAddress= :deliveryAddress, numberPhone= :numberPhone, orderDay= :orderDay, deliveryDay= :deliveryDay, amount= :amount where id= :id");
			query.setParameter("id", updateOrderViewModel.getMahd());
			query.setParameter("numberPhone", updateOrderViewModel.getSodt());
			query.setParameter("status", updateOrderViewModel.getTinhtrang());
			query.setParameter("deliveryAddress", updateOrderViewModel.getDiachi());
			query.setParameter("orderDay", Timestamp.valueOf(updateOrderViewModel.getNgaymua()), TemporalType.TIMESTAMP);
			query.setParameter("deliveryDay", Timestamp.valueOf(updateOrderViewModel.getNgaygiao()), TemporalType.TIMESTAMP);
			query.setParameter("amount", totalMoney);
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
