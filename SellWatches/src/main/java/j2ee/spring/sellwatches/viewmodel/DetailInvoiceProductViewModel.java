package j2ee.spring.sellwatches.viewmodel;

import java.util.List;

import j2ee.spring.sellwatches.models.DetailInvoice;
import j2ee.spring.sellwatches.models.Product;

public class DetailInvoiceProductViewModel {
	
	List<Product> products;
	List<DetailInvoice> detailInvoices;
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	public List<DetailInvoice> getDetailInvoices() {
		return detailInvoices;
	}
	public void setDetailInvoices(List<DetailInvoice> detailInvoices) {
		this.detailInvoices = detailInvoices;
	}
}
