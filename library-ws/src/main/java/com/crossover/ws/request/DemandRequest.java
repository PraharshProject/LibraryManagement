package com.crossover.ws.request;

/**
Author : Praharsh Vasavda
Purpose : Demand request Object
**/
public class DemandRequest {
	
	private String username;
	private String bookid;
	
	public DemandRequest(){}
	public DemandRequest(String username, String bookid) {
		super();
		this.username = username;
		this.bookid = bookid;
	}
	public String getUsername() {
		return username;
	}
	public String getBookid() {
		return bookid;
	}
	
	

}
