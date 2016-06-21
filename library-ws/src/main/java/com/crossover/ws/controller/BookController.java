package com.crossover.ws.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.crossover.service.BookService;
import com.crossover.service.exception.ServiceException;
import com.crossover.ws.exception.PublisherWSException;

/**
 Author : Praharsh Vasavda
 Purpose : Provides service to user to search for the book
**/

@Controller
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	/**
	 * Purpose : Checks for the book availability
	 * @param String, String
	 * @return Object
	 * */
	@RequestMapping(value="/check/{type}/{text}", method=RequestMethod.GET)
	@ResponseBody public Object findBook(@PathVariable String type, @PathVariable String text){
		try {
			//response = new Response((bookService.getBooks(type, text)),"SUCCESS");
			return bookService.checkBooks(type, text);
		} catch (ServiceException e) {
			//HttpStatusCodeException exception = new HttpStatusCodeException("204", "FAILURE",null,e.getErrorCode(),null);
			PublisherWSException exception = new PublisherWSException("FAILURE",e.getErrorCode() , e.getErrorMessage());
			return exception;
		}	
	}

}
