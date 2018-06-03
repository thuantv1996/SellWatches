package j2ee.spring.sellwatches.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import j2ee.spring.sellwatches.dao.ProductDAO;
import j2ee.spring.sellwatches.models.Product;
import j2ee.spring.sellwatches.models.Trademark;
import j2ee.spring.sellwatches.services.ProductService;
import j2ee.spring.sellwatches.viewmodel.ProductOnView;

@Component
public class ProductServiceImplement implements ProductService {

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
		if (countProduct < number) {
			return null;
		}
		// b1: Lấy danh sách sản phẩm bán được
		List<Product> listSell = productDAO.getListSellProduct();
		// b2: Kiểm tra xem số lượng (m) đã đáp ứng được yêu cầu (n) hay chưa
		if (listSell == null) {
			return productDAO.select("DESC").subList(0, number);
		}
		if (listSell.size() >= number) {
			return listSell.subList(0, number - 1);
		}
		// b3: lấy (n-m) sản phẩm trong danh sách sản phẩm mới
		int miss = number - listSell.size();
		List<Product> listNewProduct = productDAO.select("DESC");
		List<Product> res = new ArrayList<Product>(listSell);
		for (Product item : listNewProduct) {
			for (Product product : listSell) {
				if (item.getId() != product.getId()) {
					res.add(item);
					miss--;
					break;
				}
			}
			if (miss == 0) {
				break;
			}
		}
		return res;
	}

	public List<ProductOnView> getNewProduct(int number) {
		List<Product> lProduct = productDAO.select("DESC");
		if(lProduct.size()>number)
		{
			lProduct = lProduct.subList(0, number);
		}
		List<ProductOnView> result = new ArrayList<ProductOnView>();
		for (Product product : lProduct) {
			int idProduct = product.getId();
			int promotion = productDAO.getPromotion(idProduct);
			ProductOnView productOnView = new ProductOnView();
			productOnView.setProduct(product);
			productOnView.setPromotion(promotion);
			result.add(productOnView);
		}
		return result;
	}

	public List<ProductOnView> getRelativeProduct(int id, int n) {
		// lấy ra danh sách sản phẩm cùng nhà cung cấp (thuong hieu)
		Object[] param = { id };
		Product product = productDAO.findById(param);
		Trademark trademark = product.getTrademark();
		List<ProductOnView> result = new ArrayList<ProductOnView>();
		List<Product> lProduct = productDAO.select(trademark);
		// Tìm khuyến mãi cho từng sản phẩm
		for (Product item : lProduct) {
			int idProduct = item.getId();
			if (idProduct == id) {
				continue;
			}
			int promotion = productDAO.getPromotion(idProduct);
			ProductOnView productOnView = new ProductOnView();
			productOnView.setProduct(item);
			productOnView.setPromotion(promotion);
			result.add(productOnView);
			n--;
			if (n == 0) {
				break;
			}
		}
		return result;
	}

	public ProductOnView getProductOnView(int id) {
		Object[] param = { id };
		Product product = productDAO.findById(param);
		int promotion = productDAO.getPromotion(product.getId());
		ProductOnView result = new ProductOnView();
		result.setProduct(product);
		result.setPromotion(promotion);
		return result;
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

	public List<ProductOnView> findByKey(String key) {		
		List<ProductOnView> result = new ArrayList<ProductOnView>();
		// lấy danh sách sản phẩm với tên chứa key
		List<Product> products = productDAO.getListProductWithKey(key);
		// lấy ra khuyen mai của từng sp
		for (Product product : products) {
			int promotion = productDAO.getPromotion(product.getId());
			ProductOnView item = new ProductOnView();
			item.setProduct(product);
			item.setPromotion(promotion);
			result.add(item);
		}
		// trả về
		return result;
	}
	
	public int TakeQuantityProduct(int masp) {
		Object[] idPara = {masp};
		Product product = productDAO.findById(idPara);
		return product.getNumber();
	}
	
	public int GetPromotion(int id) {
		return productDAO.GetPromotion(id);
	}

	@Override
	public Boolean UpdateQuantityProduct(int masp, int soluong, Boolean kiemtra) {
		return productDAO.UpdateQuantityProduct(masp, soluong, kiemtra);
	}
}
