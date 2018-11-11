package impl.miw.presentation.login;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.miw.model.LoginData;

public class LoginValidator implements Validator {

	public boolean supports(Class<?> clazz) {
		return LoginData.class.equals(clazz);
	}
	

	public void validate(Object target, Errors errors) {
		LoginData loginData = (LoginData) target;
		if (loginData.getLogin() == null || loginData.getLogin().length() == 0) {
			errors.rejectValue("login", "", "Login is mandatory");
		}
		// We validate that the user and password are not the same
		if (loginData.getLogin().equals(loginData.getPassword())) {
			System.out.println("Login and password match");
			errors.reject("", "Login and password can not match.");
		}
	}

}
