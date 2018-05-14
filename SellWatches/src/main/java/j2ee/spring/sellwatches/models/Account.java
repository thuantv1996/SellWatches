package j2ee.spring.sellwatches.models;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TAIKHOAN")
public class Account {
	@Id
	@Column(name = "MATK")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "TENDN")
	private String userName;

	@Column(name = "MATKHAU")
	private String password;

	@Column(name = "NGAYDANGKY")
	private Timestamp registerDay;

	@Column(name = "TRANGTHAI")
	private int status;

	@ManyToOne
	@JoinColumn(name = "MALOAITK")
	private TypeAccount typeAccount;

	@OneToMany
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
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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
