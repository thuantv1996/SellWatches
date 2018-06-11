package j2ee.spring.sellwatches.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CHITIETKM")
//@IdClass(DetailPromotionID.class)
public class DetailPromotion implements Serializable {
	
	private static final long serialVersionUID = 1L;
//	@Id
//	@ManyToOne
//	@JoinColumn(name = "MAKM")
//	private Promotion promotion;
//
//	@Id
//	@ManyToOne
//	@JoinColumn(name = "MASP")
//	private Product product;

	@EmbeddedId
	DetailPromotionID detailPromotionID;
	
	@Column(name = "PHANTRAMKM")
	private int content;

	
	public DetailPromotionID getDetailPromotionID() {
		return detailPromotionID;
	}

	public void setDetailPromotionID(DetailPromotionID detailPromotionID) {
		this.detailPromotionID = detailPromotionID;
	}

	public int getContent() {
		return content;
	}

	public void setContent(int content) {
		this.content = content;
	}

}
