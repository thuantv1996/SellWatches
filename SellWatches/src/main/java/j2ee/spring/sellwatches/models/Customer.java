package j2ee.spring.sellwatches.models;

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

import org.springframework.format.annotation.NumberFormat;

import j2ee.spring.sellwatches.validator.Email;

@Entity
@Table(name = "KHACHHANG")
public class Customer {
	@Id
	@Column(name = "MAKH")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "TENKH", length = 50)
	private String name;

	@Email
	@Column(name = "EMAIL", length = 50)
	private String email;

	@Column(name = "SDT", length = 12)
	private String numberPhone;

	@Column(name = "GIOITINH")
	private String sex;

	@Column(name = "DIACHI")
	private String address;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "MAKH")
	private List<Order> listOrder;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "MATK")
	private Account account;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNumberPhone() {
		return numberPhone;
	}

	public void setNumberPhone(String numberPhone) {
		this.numberPhone = numberPhone;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<Order> getListOrder() {
		return listOrder;
	}

	public void setListOrder(List<Order> listOrder) {
		this.listOrder = listOrder;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

}
