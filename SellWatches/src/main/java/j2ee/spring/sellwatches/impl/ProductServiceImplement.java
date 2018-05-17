package j2ee.spring.sellwatches.impl;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import j2ee.spring.sellwatches.dao.ProductDAO;
import j2ee.spring.sellwatches.models.Product;
import j2ee.spring.sellwatches.services.ProductService;
import j2ee.spring.sellwatches.viewmodel.ProductOnView;

@Component
public class ProductServiceImplement implements ProductService{
	
	@Autowired
	private ProductDAO productDAO;
	
	public List<Product> select() {
		return productDAO.select();
	}

	public boolean insert(Product t) {
		return productDAO.insert(t);
	}

	public boolean update(Product t) {
		return productDAO.update(t);
	}

	public boolean delete(Object[] idPara) {
		return productDAO.delete(idPara);
	}

	public Product findById(Object[] idPara) {
		return productDAO.findById(idPara);
	}

	public List<Product> getSellingProduct(int number) {
		// Điều kiện thực hiện: Có tối thiểu n sản phẩm trong csdl
		int countProduct = productDAO.count();
		if(countProduct < number)
		{
			return null;
		}
		// b1: Lấy danh sách  sản phẩm bán được
		List<Product> listSell = productDAO.getListSellProduct();
		// b2: Kiểm tra xem số lượng (m) đã đáp ứng được yêu cầu (n) hay chưa
		if(listSell == null)
		{
			return productDAO.select("DESC").subList(0, number);
		}
		if(listSell.size()>=number)
		{
			return listSell.subList(0, number-1);
		}
		// b3: lấy (n-m) sản phẩm trong danh sách sản phẩm mới
		int miss = number - listSell.size();
		List<Product> listNewProduct = productDAO.select("DESC");
		List<Product> res = new ArrayList<Product>(listSell);
		for (Product item : listNewProduct) {
			for (Product product : listSell) {
				if(item.getId()!=product.getId())
				{
					res.add(item);
					miss--;
					break;
				}
			}
			if(miss==0)
			{
				break;
			}
		}
		return res;
	}

	public List<ProductOnView> getNewProduct(int number) {
		List<Product> lProduct = productDAO.select("DESC").subList(0, number);
		
		for (Product product : lProduct) {
			int idProduct = product.getId(); 
			// get list promotion
			// get list detail
			int promotion = productDAO.getPromotion(idProduct);
		}
		return null;
		
	}

	public List<Product> LoadProductAll() {
		return productDAO.LoadProductAll();
	}

	public List<Product> LoadProductMen() {
		return productDAO.LoadProductMen();
	}

	public List<Product> LoadProductWomen() {
		return productDAO.LoadProductWomen();
	}
}
