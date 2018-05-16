package j2ee.spring.sellwatches.services;

import java.util.List;
import j2ee.spring.sellwatches.models.Account;
import j2ee.spring.sellwatches.viewmodel.RegisterViewModel;

/***
 * giao diện cung cấp các dịch vụ cụ thể cho đối tượng TAIKHOAN
 * 
 * @author nguyen
 *
 */
public interface AccountService extends MSSQLService<Account> {
	public Boolean RegisterAccount(RegisterViewModel registerViewModel);
	public Boolean isExistAccount(String userName);
	public Boolean LoginAccount(String userName, String passWord);
}
