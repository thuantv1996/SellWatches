package j2ee.spring.sellwatches.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "CHITIETDONHANG")
//@IdClass(DetailInvoiceID.class)
public class DetailInvoice implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	DetailInvoiceID detailInvoiceID;
	
//	@Id
//	@ManyToOne
//	@JoinColumn(name = "MADH")
//	private Order order;
//	
//	@Id
//	@ManyToOne
//	@JoinColumn(name = "MASP")
//	private Product product;
	
	@Column(name = "SOLUONG")
	private int quantity;
	
	public DetailInvoiceID getDetailInvoiceID() {
		return detailInvoiceID;
	}

	public void setDetailInvoiceID(DetailInvoiceID detailInvoiceID) {
		this.detailInvoiceID = detailInvoiceID;
	}

//	public Order getOrder() {
//		return order;
//	}
//
//	public void setOrder(Order order) {
//		this.order = order;
//	}
//
//	public Product getProduct() {
//		return product;
//	}
//
//	public void setProduct(Product product) {
//		this.product = product;
//	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
