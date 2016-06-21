package com.crossover.service.response;

import java.io.Serializable;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
@JsonDeserialize
public class BookResponse implements Serializable{
	
	private String id;
	private String title;
	private String publisher;
	private String desc;
	private String author;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
	
}
