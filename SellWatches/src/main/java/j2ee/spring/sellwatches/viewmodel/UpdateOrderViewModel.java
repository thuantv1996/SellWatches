package j2ee.spring.sellwatches.viewmodel;

import java.sql.Timestamp;
import java.util.List;

public class UpdateOrderViewModel {
	Integer mahd;
	String tennguoinhan;
	String sodt;
	String diachi;
	String ngaymua;
	String ngaygiao;
	String tinhtrang;
	Integer[] mangmasp;
	Integer[] mangsoluong;
	String[] mangtensp;
	public Integer getMahd() {
		return mahd;
	}
	public void setMahd(Integer mahd) {
		this.mahd = mahd;
	}
	public String getTennguoinhan() {
		return tennguoinhan;
	}
	public void setTennguoinhan(String tennguoinhan) {
		this.tennguoinhan = tennguoinhan;
	}
	public String getSodt() {
		return sodt;
	}
	public void setSodt(String sodt) {
		this.sodt = sodt;
	}
	public String getDiachi() {
		return diachi;
	}
	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}
	public String getNgaymua() {
		return ngaymua;
	}
	public void setNgaymua(String ngaymua) {
		this.ngaymua = ngaymua;
	}
	public String getNgaygiao() {
		return ngaygiao;
	}
	public void setNgaygiao(String ngaygiao) {
		this.ngaygiao = ngaygiao;
	}
	public String getTinhtrang() {
		return tinhtrang;
	}
	public void setTinhtrang(String tinhtrang) {
		this.tinhtrang = tinhtrang;
	}
	public Integer[] getMangmasp() {
		return mangmasp;
	}
	public void setMangmasp(Integer[] mangmasp) {
		this.mangmasp = mangmasp;
	}
	public Integer[] getMangsoluong() {
		return mangsoluong;
	}
	public void setMangsoluong(Integer[] mangsoluong) {
		this.mangsoluong = mangsoluong;
	}
	public String[] getMangtensp() {
		return mangtensp;
	}
	public void setMangtensp(String[] mangtensp) {
		this.mangtensp = mangtensp;
	}
	
}
