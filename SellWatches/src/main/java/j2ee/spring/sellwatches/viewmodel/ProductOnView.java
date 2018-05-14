package j2ee.spring.sellwatches.viewmodel;

import j2ee.spring.sellwatches.models.Product;

public class ProductOnView {
	Product product;
	int promotion;

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getPromotion() {
		return promotion;
	}

	public void setPromotion(int promotion) {
		this.promotion = promotion;
	}
}
