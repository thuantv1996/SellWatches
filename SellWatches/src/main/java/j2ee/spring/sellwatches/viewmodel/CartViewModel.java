package j2ee.spring.sellwatches.viewmodel;

public class CartViewModel {
	int id;
	int quantity;
	int price;
	String productName;
	String imgProduct;
	
	public String getImgProduct() {
		return imgProduct;
	}
	public void setImgProduct(String imgProduct) {
		this.imgProduct = imgProduct;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
}
