package com.skiya.sportzplatform.dto;

public class AppAuthToken {

	private String token;
	private String userEmail;
	
	public AppAuthToken(String token, String userEmail) {
		super();
		this.token = token;
		this.userEmail = userEmail;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
}
