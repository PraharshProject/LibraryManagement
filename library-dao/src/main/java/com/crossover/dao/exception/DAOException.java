package com.crossover.dao.exception;

public class DAOException extends Throwable {
	
	private String errorCode;
	private String errorMessage;
	
	public DAOException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DAOException(String errorCode, String errorMessage) {
		super();
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}
	
	

}
