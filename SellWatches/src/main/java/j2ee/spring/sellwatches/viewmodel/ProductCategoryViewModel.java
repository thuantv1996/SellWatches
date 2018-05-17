package j2ee.spring.sellwatches.viewmodel;

import java.util.List;

import j2ee.spring.sellwatches.models.Product;

public class ProductCategoryViewModel {
	public List<Product> listProduct;
	public int totalPage;
	public int Index;
	public int Next;
	public int Prev;
	public String cateKey;
	public int pageSize;
	public int pageDislayNumber;
	public int startPageIndex;
	public int endPageIndex;
	
	public int getStartPageIndex() {
		return startPageIndex;
	}
	public void setStartPageIndex(int startPageIndex) {
		this.startPageIndex = startPageIndex;
	}
	public int getEndPageIndex() {
		return endPageIndex;
	}
	public void setEndPageIndex(int endPageIndex) {
		this.endPageIndex = endPageIndex;
	}

	public int getPageDislayNumber() {
		return pageDislayNumber;
	}
	public void setPageDislayNumber(int pageDislayNumber) {
		this.pageDislayNumber = pageDislayNumber;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public List<Product> getListProduct() {
		return listProduct;
	}
	public void setListProduct(List<Product> listProduct) {
		this.listProduct = listProduct;
	}

	public int getIndex() {
		return Index;
	}
	public void setIndex(int index) {
		Index = index;
	}
	public int getNext() {
		return Index == totalPage ? totalPage : Index + 1;
	}

	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getPrev() {
		return Index <= 2 ? 1 : Index - 1;
	}

	public String getCateKey() {
		return cateKey;
	}
	public void setCateKey(String cateKey) {
		this.cateKey = cateKey;
	}
}
