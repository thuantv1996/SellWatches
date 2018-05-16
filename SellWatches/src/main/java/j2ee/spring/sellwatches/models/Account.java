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
import javax.validation.constraints.Size;

import j2ee.spring.sellwatches.validator.Email;

@Entity
@Table(name = "TAIKHOAN")
public class Account {
	@Id
	@Column(name = "MATK")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Size(min = 6, max = 20)
	@Column(name = "TENDN")
	private String userName;

	@Size(min = 6, max = 32)
	@Column(name = "MATKHAU")
	private String passWord;

	@Column(name = "NGAYDANGKY")
	private Timestamp registerDay;

	@Column(name = "TRANGTHAI")
	private int status;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "MALOAITK")
	private TypeAccount typeAccount;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "MATK")
	private List<Customer> listCustomer;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return passWord;
	}

	public void setPassword(String password) {
		this.passWord = password;
	}

	public Timestamp getRegisterDay() {
		return registerDay;
	}

	public void setRegisterDay(Timestamp registerDay) {
		this.registerDay = registerDay;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public TypeAccount getTypeAccount() {
		return typeAccount;
	}

	public void setTypeAccount(TypeAccount typeAccount) {
		this.typeAccount = typeAccount;
	}

	public List<Customer> getListCustomer() {
		return listCustomer;
	}

	public void setListCustomer(List<Customer> listCustomer) {
		this.listCustomer = listCustomer;
	}

}
