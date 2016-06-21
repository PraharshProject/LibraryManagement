package com.crossover.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crossover.dao.entity.Book;
import com.crossover.dao.exception.DAOException;
import com.crossover.dao.impl.MongoDAOImpl;
import com.crossover.service.exception.ServiceException;

/**
Author : Praharsh Vasavda
Purpose : Service to connect to cloud DB
**/
@Service(value="bookService")
public class PublisherService {
	
	@Autowired
	private MongoDAOImpl daoImpl;
	
	private List<Book> book;
	
	/**
	 * 
	 * @param type
	 * @param text
	 * @return List
	 * @throws ServiceException
	 */
	public List<Book> getBooks(String type, String text) throws ServiceException{
		if("title".equalsIgnoreCase(type)){
			try {
				book = daoImpl.searchByTitle(text);
				return book;
			} catch (DAOException e) {
				throw new ServiceException(e.getErrorCode(), e.getErrorMessage());
			}
		}
		if("publisher".equalsIgnoreCase(type)){
			try {
				book = daoImpl.searchByPublisher(text);
				return book;
			} catch (DAOException e) {
				throw new ServiceException(e.getErrorCode(), e.getErrorMessage());
			}
		}
		if("author".equalsIgnoreCase(type)){
			try {
				book = daoImpl.searchByAuthor(text);
				return book;
			} catch (DAOException e) {
				throw new ServiceException(e.getErrorCode(), e.getErrorMessage());
			}
		}
		return null;
	}
	
}
