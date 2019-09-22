package com.seal.model;

import java.io.Serializable;

public class UserModel implements Serializable{

	private static final long serialVersionUID = -1251478340940212866L;

	private String password;
	
	private String username;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
