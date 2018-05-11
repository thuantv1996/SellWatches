package j2ee.spring.sellwatches.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CHITIETKM")
public class DetailsPromotions {
	@Id
	@ManyToOne
	@JoinColumn(name = "MAKM")
	private Promotion promotion;

	@Id
	@ManyToOne
	@JoinColumn(name = "MASP")
	private Product product;

	@Column(name = "PHANTRAMKM")
	private int content;

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

	public int getContent() {
		return content;
	}

	public void setContent(int content) {
		this.content = content;
	}

}
