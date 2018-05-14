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
	private String id;

	@Column(name = "NGAYBD")
	private Timestamp beginDay;

	@Column(name = "NGAYKT")
	private Timestamp endDay;

	@Column(name = "TENKM")
	private String namePromotion;

	@OneToMany
	@JoinColumn(name = "MAKM")
	List<DetailPromotion> listDetail;

	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Timestamp getBeginDay() {
		return beginDay;
	}

	public void setBeginDay(Timestamp beginDay) {
		this.beginDay = beginDay;
	}

	public Timestamp getEndDay() {
		return endDay;
	}

	public void setEndDay(Timestamp engDay) {
		this.endDay = engDay;
	}

	public String getNamePromotion() {
		return namePromotion;
	}

	public void setNamePromotion(String namePromotion) {
		this.namePromotion = namePromotion;
	}

	public List<DetailPromotion> getListDetail() {
		return listDetail;
	}

	public void setListDetail(List<DetailPromotion> listDetail) {
		this.listDetail = listDetail;
	}

}
