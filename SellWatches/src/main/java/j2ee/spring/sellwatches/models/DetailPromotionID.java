package j2ee.spring.sellwatches.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class DetailPromotionID implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Column(name="MAKM")
	private String promotion;
	@Column(name = "MASP")
	private int product;
	
	public String getPromotion() {
		return promotion;
	}
	public void setPromotion(String promotion) {
		this.promotion = promotion;
	}
	public int getProduct() {
		return product;
	}
	public void setProduct(int product) {
		this.product = product;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == this)
			return true;
		else
			return false;
	}
}
