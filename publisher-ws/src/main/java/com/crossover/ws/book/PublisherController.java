package com.crossover.ws.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.crossover.service.PublisherService;
import com.crossover.service.exception.ServiceException;
import com.crossover.ws.exception.PublisherWSException;
import com.crossover.ws.response.Response;

/**
Author : Praharsh Vasavda
Purpose : Connnect to Cloud DB
**/
@Controller
public class PublisherController {
	
	@Autowired
	private PublisherService publisherService;
	
	private Response response;
	
	/**
	 * 
	 * @param type
	 * @param text
	 * @return Object
	 */
	@RequestMapping(value="/search/{type}/{text}", method=RequestMethod.GET)
	@ResponseBody public Object findBook(@PathVariable String type, @PathVariable String text){
		try {
			return publisherService.getBooks(type, text);
		} catch (ServiceException e) {
			PublisherWSException exception = new PublisherWSException("FAILURE",e.getErrorCode() , e.getErrorMessage());
			return exception;
		}	
	}

}
