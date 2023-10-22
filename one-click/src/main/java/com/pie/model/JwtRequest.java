package com.pie.model;

public class JwtRequest {
	
	String email;
	String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public JwtRequest() {
		
	}

	public JwtRequest(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}


}
