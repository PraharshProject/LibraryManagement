package com.crossover.service.exception;

public class ServiceException extends Throwable {
	
	private String errorCode;
	private String errorMessage;
	
	public ServiceException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ServiceException(String errorCode, String errorMessage) {
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
