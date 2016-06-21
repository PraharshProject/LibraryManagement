package com.crossover.dao.entity;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection="Book")
public class Book{

	@Id
	private String id;
	@Field(value="Title")
	private String title;
	@Field(value="Publisher")
	private String publisher;
	@Field(value="Description")
	private String desciption;
	@Field(value="Authors")
	private String authors;
	public Book(String title, String publisher, String desciption, String authors) {
		super();
		//this.id = id;
		this.title = title;
		this.publisher = publisher;
		this.desciption = desciption;
		this.authors = authors;
	}
	public String getId() {
		return id;
	}
	public String getTitle() {
		return title;
	}
	public String getPublisher() {
		return publisher;
	}
	public String getDesciption() {
		return desciption;
	}
	public String getAuthors() {
		return authors;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", publisher=" + publisher + ", desciption=" + desciption
				+ ", authors=" + authors + "]";
	}
	
	
}
