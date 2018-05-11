package j2ee.spring.sellwatches.services;

import java.util.List;

/**
 * giao diện cung cấp các dịch vụ tương tác với csdl
 * 
 * @author thuan
 *
 * @param <T>
 *            Đối tượng cần tương tác
 */
public interface MSSQLService<T> {
	/***
	 * Lấy danh sách đối tượng từ database
	 * 
	 * @return danh sách đối tượng hoặc null nếu không có
	 */
	List<T> select();

	/***
	 * Thêm đối tượng vào Database
	 * 
	 * @param t
	 *            đối tượng cần thêm
	 * @return true nếu thành công, false nếu xãy ra ngoại lệ
	 */
	boolean insert(T t);

	/***
	 * cập nhật đối tượng trong database
	 * 
	 * @param t
	 *            đối tượng cập nhật
	 * @return true nếu thành công, false nếu thất bại hoặc có ngoại lệ xãy ra
	 */
	boolean update(T t);

	/***
	 * Xóa một đối tượng trong database
	 * 
	 * @param idPara
	 *            danh sách khóa chính của đối tượng
	 * @return true nếu xóa thành công và false nếu ngược lại
	 */
	boolean delete(Object[] idPara);

	/***
	 * Tìm một đối tượng trong database
	 * 
	 * @param idPara
	 *            Danh sách khóa chính của đối tượng
	 * @return đối tượng cần tìm hoặc null nếu không tìm thấy
	 */
	T findById(Object[] idPara);
}
