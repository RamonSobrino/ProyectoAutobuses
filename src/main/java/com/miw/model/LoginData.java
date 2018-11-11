package com.miw.model;

import javax.validation.constraints.NotEmpty;

public class LoginData {

	@NotEmpty
	private String login;
	private String password;
	private String captcha;
	
	
	public String getCaptcha() {
		return captcha;
	}
	public void setCaptcha(String captcha) {
		this.captcha = captcha;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	@Override
	public String toString() {
		return "LoginData [login=" + login + ", password=" + password + ", captcha=" + captcha+ "]";
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
