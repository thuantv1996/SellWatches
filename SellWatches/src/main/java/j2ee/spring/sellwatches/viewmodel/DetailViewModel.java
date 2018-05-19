package j2ee.spring.sellwatches.viewmodel;

import java.util.List;

public class DetailViewModel {
	private List<ProductOnView> relatedProducts;
	private List<ProductOnView> newProducts;
	private ProductOnView product;

	public List<ProductOnView> getRelatedProducts() {
		return relatedProducts;
	}

	public void setRelatedProducts(List<ProductOnView> relatedProducts) {
		this.relatedProducts = relatedProducts;
	}

	public List<ProductOnView> getNewProducts() {
		return newProducts;
	}

	public void setNewProducts(List<ProductOnView> newProducts) {
		this.newProducts = newProducts;
	}

	public ProductOnView getProduct() {
		return product;
	}

	public void setProduct(ProductOnView product) {
		this.product = product;
	}

}
