package com.crossover.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import com.crossover.dao.entity.Book;
import com.crossover.dao.entity.User;
import com.crossover.dao.exception.DAOException;

import junit.framework.Assert;

@TestExecutionListeners( { DependencyInjectionTestExecutionListener.class })
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/testSpringConfig.xml"})
public class MongoDAOImplTest {
	
	@Mock
	private MongoTemplate mongoTemplate;
	
	@InjectMocks
	private MongoDAOImpl daoImpl;
	
	 @Before
	    public void initMocks(){
	        MockitoAnnotations.initMocks(this);
	    }
	
	@Test
	public void checkDB(){
		Assert.assertNotNull(mongoTemplate);
		Assert.assertNotNull(mongoTemplate.findAll(User.class));
		System.out.print("test"+mongoTemplate.findAll(User.class));
	}
	
	@Test(expected = DAOException.class)
	public void searchByTitleTest() throws DAOException{
		List<Book> books = new ArrayList<Book>();
		Book book1 = new Book("The","Dummu","Desc","Trial");
		Book book2 = new Book("The1","Dummu1","Desc1","Trial1");
		books.add(book1);
		books.add(book2);
		Query searchTest = new Query();
		Mockito.when(mongoTemplate.find(searchTest, Book.class)).thenReturn(books);
		List<Book> result = daoImpl.searchByTitle("The");
		Assert.assertNotNull(result);
	}
	
	@Test(expected = DAOException.class)
	public void searchByPublisherTest() throws DAOException{
		List<Book> books = new ArrayList<Book>();
		Book book1 = new Book("The","David","Desc","Trial");
		Book book2 = new Book("The1","Rob","Desc1","Trial1");
		books.add(book1);
		books.add(book2);
		Query searchTest = new Query();
		Mockito.when(mongoTemplate.find(searchTest, Book.class)).thenReturn(books);
		List<Book> result = daoImpl.searchByPublisher("David");
		Assert.assertNotNull(result);
	}
	
	@Test(expected = DAOException.class)
	public void searchByAuthorTest() throws DAOException{
		List<Book> books = new ArrayList<Book>();
		Book book1 = new Book("The","Dummu","Desc","John");
		Book book2 = new Book("The1","Dummu1","Desc1","Steve");
		books.add(book1);
		books.add(book2);
		Query searchTest = new Query();
		Mockito.when(mongoTemplate.find(searchTest, Book.class)).thenReturn(books);
		List<Book> result = daoImpl.searchByAuthor("John");
		Assert.assertNotNull(result);
	}

}
