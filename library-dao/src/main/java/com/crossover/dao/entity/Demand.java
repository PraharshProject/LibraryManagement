package com.crossover.dao.entity;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection="Demand")
public class Demand {
	
	@Id
	private String id;
	@Field(value="Username")
	private String username;
	@Field(value="BookId")
	private String bookId;
	@Field(value="Raised on")
	private String dt;
	@Field(value="Status")
	private String status;
	
	public Demand(){}
	
	public Demand(String username, String bookId, String dt, String status) {
		super();
		this.username = username;
		this.bookId = bookId;
		this.dt = dt;
		this.status = status;
	}

	public String getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public String getBookId() {
		return bookId;
	}
	
	public String getDt() {
		return dt;
	}

	public String getStatus() {
		return status;
	}
	
	

}
