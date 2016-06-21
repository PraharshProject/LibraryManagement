package com.crossover.dao.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection="User")
public class User {
	
	@Id
	private String id;
	@Field(value="Username")
	private String username;
	@Field(value="Password")
	private String password;
	public User(String username, String password) {
		super();
		//this.id = id;
		this.username = username;
		this.password = password;
	}
	public String getId() {
		return id;
	}
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + "]";
	}
	

}
