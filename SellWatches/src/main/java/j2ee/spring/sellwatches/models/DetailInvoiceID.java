package j2ee.spring.sellwatches.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class DetailInvoiceID implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "MASP")
	int productId;
	
	@Column(name = "MADH")
	int orderId;

	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj == this)
			return true;
		else
			return false;
	}
}
