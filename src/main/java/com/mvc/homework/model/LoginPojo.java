package com.mvc.homework.model;

public class LoginPojo{
	private String username;
	private String password;

	public LoginPojo() {}

	public LoginPojo(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "UserDto [username=" + username + ", password=" + password + "]";
	}
	
}
