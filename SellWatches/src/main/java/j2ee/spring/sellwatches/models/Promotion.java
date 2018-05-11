package j2ee.spring.sellwatches.models;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "KHUYENMAI")
public class Promotion {
	@Id
	@Column(name = "MAKM")
	private int id;

	@Column(name = "NGAYBATDAU")
	private Timestamp beginDay;

	@Column(name = "NGAYKETTHUC")
	private Timestamp engDay;

	@Column(name = "TENKM")
	private String namePromotion;

	@OneToMany
	@JoinColumn(name = "MAKM")
	List<DetailsPromotions> listDetail;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Timestamp getBeginDay() {
		return beginDay;
	}

	public void setBeginDay(Timestamp beginDay) {
		this.beginDay = beginDay;
	}

	public Timestamp getEngDay() {
		return engDay;
	}

	public void setEngDay(Timestamp engDay) {
		this.engDay = engDay;
	}

	public String getNamePromotion() {
		return namePromotion;
	}

	public void setNamePromotion(String namePromotion) {
		this.namePromotion = namePromotion;
	}

	public List<DetailsPromotions> getListDetail() {
		return listDetail;
	}

	public void setListDetail(List<DetailsPromotions> listDetail) {
		this.listDetail = listDetail;
	}

}
