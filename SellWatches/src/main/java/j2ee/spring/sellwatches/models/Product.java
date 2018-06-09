package j2ee.spring.sellwatches.models;

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
@Table(name = "SANPHAM")
public class Product {
	@Id
	@Column(name = "MASP")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "TENSP")
	private String nameProduct;

	@Column(name = "HINHLON")
	private String bigImage;

	@Column(name = "HINHNHO")
	private String smallImage;

	@Column(name = "MOTA")
	private String description;

	@Column(name = "DANHGIA")
	private String evalute;

	@Column(name = "SOLUONG")
	private int number;

	@Column(name = "DONGIA")
	private int price;

	@ManyToOne
	@JoinColumn(name = "MATH")
	private Trademark trademark;

	@ManyToOne
	@JoinColumn(name = "MALOAISP")
	private Category category;

	@OneToMany
	@JoinColumn(name = "MASP")
	private List<DetailInvoice> listDetailInvoice;

	@OneToMany
	@JoinColumn(name = "MASP")
	private List<DetailPromotion> listDetailPromotion;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNameProduct() {
		return nameProduct;
	}

	public void setNameProduct(String nameProduct) {
		this.nameProduct = nameProduct;
	}

	public String getBigImage() {
		return bigImage;
	}

	public void setBigImage(String bigImage) {
		this.bigImage = bigImage;
	}

	public String getSmallImage() {
		return smallImage;
	}

	public void setSmallImage(String smallImage) {
		this.smallImage = smallImage;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEvalute() {
		return evalute;
	}

	public void setEvalute(String evalute) {
		this.evalute = evalute;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Trademark getTrademark() {
		return trademark;
	}

	public void setTrademark(Trademark trademark) {
		this.trademark = trademark;
	}

	public List<DetailInvoice> getListDetailInvoice() {
		return listDetailInvoice;
	}

	public void setListDetailInvoice(List<DetailInvoice> listDetailInvoice) {
		this.listDetailInvoice = listDetailInvoice;
	}

	public List<DetailPromotion> getListDetailsPromotions() {
		return listDetailPromotion;
	}

	public void setListDetailPromotions(List<DetailPromotion> listDetailsPromotions) {
		this.listDetailPromotion = listDetailsPromotions;
	}

}
