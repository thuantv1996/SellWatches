package j2ee.spring.sellwatches.viewmodel;

import java.util.List;

public class SearchViewModel {
	private List<ProductOnView> products;
	private int curPage;
	private int totalPage;
	private int beginIndex;
	private int endIndex;
	private String key;
	
	public List<ProductOnView> getProducts() {
		return products;
	}
	public void setProducts(List<ProductOnView> products) {
		this.products = products;
	}
	public int getCurPage() {
		return curPage;
	}
	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getBeginIndex() {
		return beginIndex;
	}
	public void setBeginIndex(int beginIndex) {
		this.beginIndex = beginIndex;
	}
	public int getEndIndex() {
		return endIndex;
	}
	public void setEndIndex(int endIndex) {
		this.endIndex = endIndex;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	
}
