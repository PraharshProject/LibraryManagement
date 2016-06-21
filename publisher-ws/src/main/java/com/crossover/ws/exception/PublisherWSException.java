package com.crossover.ws.exception;


/**
Author : Praharsh Vasavda
Purpose : WS layer exception
**/
public class PublisherWSException extends Throwable {
	
	private String status;
	private String errorCode;
	private String errorReason;
	
	public PublisherWSException(){}
	
	public PublisherWSException(String status, String errorCode, String errorReason) {
		super();
		this.status = status;
		this.errorCode = errorCode;
		this.errorReason = errorReason;
	}

	public String getStatus() {
		return status;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public String getErrorReason() {
		return errorReason;
	}
	
	

}
