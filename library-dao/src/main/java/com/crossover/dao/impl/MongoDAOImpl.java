package com.crossover.dao.impl;

import java.util.List;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;
import com.crossover.dao.entity.Book;
import com.crossover.dao.entity.Demand;
import com.crossover.dao.entity.User;
import com.crossover.dao.exception.DAOException;

/**
Author : Praharsh Vasavda
Purpose : DAO layer to interact with DB
**/

@Component(value="daoImpl")
public class MongoDAOImpl {
	@Autowired(required=true)
	private MongoTemplate mongoTemplate;
	
	private List<Book> bookList;
	private List<Demand> demandList;
	private User user;
	
	/**
	 * Find book by title
	 * @param title
	 * @return List
	 * @throws DAOException
	 */
	public List<Book> searchByTitle(String title) throws DAOException{
		try {
			Query search = new Query(Criteria.where("Title").regex(".*"+title+".*", "i"));
			bookList = mongoTemplate.find(search, Book.class);
			System.out.println("result::"+bookList);
			if(bookList.isEmpty() || null == bookList){
				throw new DAOException("NO_DATA_FOUND", "Title is not available");
			}
			return bookList;
		} catch (Exception e) {
			throw new DAOException("Cloud_Unreachable", e.getMessage());
		}
	}
	
	/**
	 * Find book by publisher name
	 * @param publisher
	 * @return List
	 * @throws DAOException
	 */
	public List<Book> searchByPublisher(String publisher) throws DAOException{
		try {
			Query search = new Query(Criteria.where("Publisher").regex(".*"+publisher+".*", "i"));
			bookList = mongoTemplate.find(search, Book.class);
			System.out.println("result::"+bookList);
			if(bookList.isEmpty() || null == bookList){
				throw new DAOException("NO_DATA_FOUND", "No book for "+publisher+" is available");
			}
			return bookList;
		} catch (Exception e) {
			throw new DAOException("Cloud_Unreachable", e.getMessage());
		}
	}
	
	/**
	 * Find book by author name
	 * @param author
	 * @return List
	 * @throws DAOException
	 */
	public List<Book> searchByAuthor(String author) throws DAOException{
		try {
			Query search = new Query(Criteria.where("Authors").regex(".*"+author+".*", "i"));
			bookList = mongoTemplate.find(search, Book.class);
			System.out.println("result::"+bookList);
			if(bookList.isEmpty() || null == bookList){
				throw new DAOException("NO_DATA_FOUND", "No book of "+author+" is available");
			}
			return bookList;
		} catch (Exception e) {
			throw new DAOException("Cloud_Unreachable", e.getMessage());
		}
	}
	
	/**
	 * Find book name by id
	 * @param id
	 * @return Sting
	 * @throws DAOException
	 */
	public String findBookName(String id) throws DAOException{
		try {
			ObjectId objectId= new ObjectId(id);        
			//BasicDBObject obj = new BasicDBObject();        
			//obj.append("_id", objectId);
			Query search = new Query(Criteria.where("_id").is(objectId));
			Book book = mongoTemplate.findOne(search, Book.class);
			if(null == book){
				throw new DAOException("NO_DATA_FOUND", "No book found");
			}
			return book.getTitle();
		} catch (Exception e) {
			throw new DAOException("Cloud_Unreachable", e.getMessage());
		}
	}
	/**
	 * Insert demand in the collection
	 * @param demand
	 * @throws DAOException
	 */
	public void insertDemand(Demand demand) throws DAOException{
		try {
			mongoTemplate.save(demand);
		} catch (Exception e) {
			throw new DAOException("Cloud_Unreachable", e.getMessage());
		}
	}
	
	/**
	 * Search for user for authentication
	 * @param username
	 * @return Object
	 * @throws DAOException
	 */
	public User searchUser(String username) throws DAOException{
		try {
			Query search = new Query(Criteria.where("username").is(username));
			user = mongoTemplate.findOne(search, User.class);
			System.out.println("result::"+bookList);
			if(null == user){
				throw new DAOException("NO_DATA_FOUND", "User is not found");
			}
			return user;
		} catch (Exception e) {
			throw new DAOException("NO_DATA_FOUND", "User is not found");
		}
	}
	/**
	 * Find previous demands
	 * @param username
	 * @return List
	 * @throws DAOException
	 */
	public List<Demand> findDemands(String username) throws DAOException{
		try {
			Query search = new Query(Criteria.where("username").is(username));
			demandList = mongoTemplate.find(search, Demand.class);
			System.out.println("result::"+demandList);
			if(demandList.isEmpty() || null == demandList){
				throw new DAOException("NO_DATA_FOUND", "No demand found");
			}
			return demandList;
		} catch (Exception e) {
			throw new DAOException("Cloud_Unreachable", e.getMessage());
		}
	}
	

}
