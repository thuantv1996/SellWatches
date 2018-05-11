package j2ee.spring.sellwatches.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "LOAISANPHAM")
public class Category {
	@Id
	@Column(name = "MALOAISP")
	private String id;

	@Column(name = "TENLOAISP")
	private String nameCategory;

	@OneToMany
	@JoinColumn(name = "MALOAISP")
	private List<Product> listProduct;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNameCategory() {
		return nameCategory;
	}

	public void setNameCategory(String nameCategory) {
		this.nameCategory = nameCategory;
	}

	public List<Product> getListProduct() {
		return listProduct;
	}

	public void setListProduct(List<Product> listProduct) {
		this.listProduct = listProduct;
	}

}
