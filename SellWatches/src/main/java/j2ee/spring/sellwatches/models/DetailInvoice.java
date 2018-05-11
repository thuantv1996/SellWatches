package j2ee.spring.sellwatches.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "CHITIETDONHANG")
public class DetailInvoice {

	@Id
	@OneToMany
	@JoinColumn(name = "MADH")
	private Order order;
	
	@Id
	@OneToMany
	@JoinColumn(name = "MASP")
	private Product product;
	
	@Column(name = "SOLUONG")
	private int quantity;

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
