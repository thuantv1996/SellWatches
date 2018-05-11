package j2ee.spring.sellwatches.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "THUONGHIEU")
public class Trademark {
	@Id
	@Column(name = "MATH")
	int id;

	@Column(name = "TENTH")
	String name;

	@Column(name = "HINHTH")
	String image;

	@OneToMany
	@JoinColumn(name = "MATH")
	private List<Product> listProduct;

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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public List<Product> getListProduct() {
		return listProduct;
	}

	public void setListProduct(List<Product> listProduct) {
		this.listProduct = listProduct;
	}
}
