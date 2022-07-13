package com.test.person.model;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Person {
	private final UUID id;
	private final String name;
	private final String email;
	private final String password;
	private final long phone;
	
	
	public UUID getId() {
		return id;
	}


	public String getName() {
		return name;
	}


	public String getEmail() {
		return email;
	}


	public String getPassword() {
		return password;
	}


	public long getPhone() {
		return phone;
	}


	public Person(@JsonProperty("id") UUID id, 
			@JsonProperty("name") String name, 
			@JsonProperty("email") String email, 
			@JsonProperty("password")String password, 
			@JsonProperty("phone") long phone) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.phone = phone;
	}

}
