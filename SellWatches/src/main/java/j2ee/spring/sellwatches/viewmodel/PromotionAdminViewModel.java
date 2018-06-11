package j2ee.spring.sellwatches.viewmodel;

public class PromotionAdminViewModel {

	private String id;
	private String namePromotion;
	private String beginDay;
	private String endDay;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNamePromotion() {
		return namePromotion;
	}
	public void setNamePromotion(String namePromotion) {
		this.namePromotion = namePromotion;
	}
	public String getBeginDay() {
		return beginDay;
	}
	public void setBeginDay(String beginDay) {
		this.beginDay = beginDay;
	}
	public String getEndDay() {
		return endDay;
	}
	public void setEndDay(String endDay) {
		this.endDay = endDay;
	}
}
