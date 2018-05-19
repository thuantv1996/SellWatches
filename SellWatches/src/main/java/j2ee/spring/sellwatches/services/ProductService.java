package j2ee.spring.sellwatches.services;

import java.util.List;

import j2ee.spring.sellwatches.models.Product;
import j2ee.spring.sellwatches.viewmodel.ProductOnView;

public interface ProductService extends MSSQLService<Product>{
	// get selling product
	
	/***
	 * phương thức lấy ra danh sách sản phẩm bán chạy 
	 * @param number số lượng lấy ra
	 * @return danh sách sản phẩm bán chạy, nếu không có sẽ lấy ra danh sách sản phẩm mới nhất
	 */
	List<Product> getSellingProduct(int number);

	List<ProductOnView> getNewProduct(int i);

	List<ProductOnView> getRelativeProduct(int id, int n);

	ProductOnView getProductOnView(int id);
	
}
