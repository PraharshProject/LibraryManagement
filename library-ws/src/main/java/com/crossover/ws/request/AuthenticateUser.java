package com.crossover.ws.request;

/**
Author : Praharsh Vasavda
Purpose : Autheticate user request
**/
public class AuthenticateUser {
	
	private String username;
	private String password;
	
	public AuthenticateUser(){}
	public AuthenticateUser(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	
	

}
