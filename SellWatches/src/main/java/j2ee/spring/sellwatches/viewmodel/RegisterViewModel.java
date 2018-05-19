package j2ee.spring.sellwatches.viewmodel;

import javax.validation.constraints.Size;

import j2ee.spring.sellwatches.validator.Email;

public class RegisterViewModel {
	public String firstName;
	
	public String lastName;
	
	public String address;
	
	@Email
	public String email;
	
	public String numberPhone;
	
	public String sex;
	
	@Size(min = 6, max = 20)
	public String userName;
	
	@Size(min = 6, max = 32)
	public String passWord;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNumberPhone() {
		return numberPhone;
	}
	public void setNumberPhone(String numberPhone) {
		this.numberPhone = numberPhone;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
}
