package j2ee.spring.sellwatches.viewmodel;

import java.util.List;

import j2ee.spring.sellwatches.models.Product;

public class HomeViewModel {
	List<Product> sellingProduct;
	List<ProductOnView> newProduct;
	public List<Product> getSellingProduct() {
		return sellingProduct;
	}
	public void setSellingProduct(List<Product> sellingProduct) {
		this.sellingProduct = sellingProduct;
	}
	public List<ProductOnView> getNewProduct() {
		return newProduct;
	}
	public void setNewProduct(List<ProductOnView> newProduct) {
		this.newProduct = newProduct;
	}

	
}

