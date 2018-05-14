package j2ee.spring.sellwatches.models;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
public class DetailPromotionID {
	private Promotion promotion;
	private Product product;

	public Promotion getPromotion() {
		return promotion;
	}

	public void setPromotion(Promotion promotion) {
		this.promotion = promotion;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}
