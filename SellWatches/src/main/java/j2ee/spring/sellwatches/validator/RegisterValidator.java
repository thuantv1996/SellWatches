package j2ee.spring.sellwatches.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import j2ee.spring.sellwatches.viewmodel.RegisterViewModel;

public class RegisterValidator implements Validator{

	public boolean supports(Class<?> clazz) {
		return RegisterViewModel.class.equals(clazz);
	}

	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "firstName.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "lastName.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address", "address.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "email.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "numberPhone", "numberPhone.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "sex", "sex.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "userName.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "passWord", "passWord.required");
				
		RegisterViewModel registerViewModel = (RegisterViewModel) target;
		
		if(!validate(registerViewModel.getEmail())) {
			errors.rejectValue("email", "CheckInvalidMail", new Object[] {"'email'"}, "Email Invalid");
		}
	}
	
	public static final Pattern VALID_EMAIL_ADDRESS_REGEX = 
			Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

	public static boolean validate(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX .matcher(emailStr);
        return matcher.find();
	}

}
