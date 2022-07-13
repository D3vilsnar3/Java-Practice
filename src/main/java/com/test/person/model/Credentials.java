package com.test.person.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Credentials {
	private final String email;
	private final String password;
	public String getEmail() {
		return email;
	}
	public String getPassword() {
		return password;
	}
	public Credentials(@JsonProperty("email")String email, 
			@JsonProperty("password")String password) {
		this.email = email;
		this.password = password;
	}
	

}
