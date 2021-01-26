package com.skiya.sportzplatform.dto;

public class LoginUser {
	
	private String userEmail;

	private String password;
	
	private String token;

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String resetToken) {
		this.token = resetToken;
	}

	@Override
	public String toString() {
		return "LoginUser [userEmail=" + userEmail + ", password=" + password + ", token=" + token + "]";
	}
	
	
	
}
