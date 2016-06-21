package com.crossover.ws.response;

import java.util.List;

import com.crossover.dao.entity.Book;

public class Response {
	
	private List<Book> books;
	private String status;
	
	public Response() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Response(List<Book> books, String status) {
		super();
		this.books = books;
		this.status = status;
	}

	public List<Book> getBookId() {
		return books;
	}

	public String getStatus() {
		return status;
	}
	
	

}
