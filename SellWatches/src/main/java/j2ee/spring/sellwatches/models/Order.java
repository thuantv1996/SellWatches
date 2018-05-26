package j2ee.spring.sellwatches.models;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "DONHANG")
public class Order {
	@Id
	@Column(name = "MADH")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "TRANGTHAI", length = 20)
	private String status;
	@Column(name = "DIACHIGIAO")
	private String deliveryAddress;

	@Column(name = "SDT", length = 12)
	private String numberPhone;

	@Column(name = "NGAYDAT")
	private Timestamp orderDay;

	@Column(name = "NGAYGIAO")
	private Timestamp deliveryDay;

	@Column(name = "MOTA")
	private String describe;

	@Column(name = "TONGTIEN")
	private float amount;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "MAKH")
	private Customer customer;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "MADH")
	private List<DetailInvoice> listDetail;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	public String getNumberPhone() {
		return numberPhone;
	}

	public void setNumberPhone(String numberPhone) {
		this.numberPhone = numberPhone;
	}

	public Timestamp getOrderDay() {
		return orderDay;
	}

	public void setOrderDay(Timestamp orderDay) {
		this.orderDay = orderDay;
	}

	public Timestamp getDeliveryDay() {
		return deliveryDay;
	}

	public void setDeliveryDay(Timestamp deliveryDay) {
		this.deliveryDay = deliveryDay;
	}

	public String getDescribe() {
		return describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<DetailInvoice> getListDetail() {
		return listDetail;
	}

	public void setListDetail(List<DetailInvoice> listDetail) {
		this.listDetail = listDetail;
	}

}
