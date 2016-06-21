package com.crossover.ws.response;

/**
Author : Praharsh Vasavda
Purpose : Resonse Object for Library WS
**/
public class UserResponse {
	
	private String status;
	private String username;
	private String errorCode;
	private String errorMessage;
	
	
	public UserResponse(String status, String username) {
		super();
		this.status = status;
		this.username = username;
	}
	
	public UserResponse(String status, String errorCode, String errorMessage) {
		super();
		this.status = status;
		this.errorCode = errorCode;
	}
	public String getStatus() {
		return status;
	}
	public String getUsername() {
		return username;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}
	
	
	

}
