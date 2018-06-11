package j2ee.spring.sellwatches.viewmodel;

import j2ee.spring.sellwatches.models.Product;

public class DetailPromotionViewModel {

	private String idPromotion;
	private int idProduct;
	private int content;
	private Product product;
	
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public String getIdPromotion() {
		return idPromotion;
	}
	public void setIdPromotion(String idPromotion) {
		this.idPromotion = idPromotion;
	}
	public int getIdProduct() {
		return idProduct;
	}
	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}
	public int getContent() {
		return content;
	}
	public void setContent(int content) {
		this.content = content;
	}
	
	@Override
	public String toString() {
		return "{idPromotion:"+idPromotion+", idProduct:"+idProduct+", content:"+content+"}";
	}
}
