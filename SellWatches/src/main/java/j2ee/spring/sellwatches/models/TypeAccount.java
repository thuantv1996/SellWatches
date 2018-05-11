package j2ee.spring.sellwatches.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "LOAITK")
public class TypeAccount {

	@Id
	@Column(name = "MALOAITK")
	private String id;

	@Column(name = "TENLOAITK")
	private String typeName;

	@OneToMany
	@JoinColumn(name = "MALOAITK")
	private List<Account> listAccount;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public List<Account> getListAccount() {
		return listAccount;
	}

	public void setListAccount(List<Account> listAccount) {
		this.listAccount = listAccount;
	}
}
