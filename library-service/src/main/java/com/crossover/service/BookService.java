package com.crossover.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.crossover.service.exception.ServiceException;
import com.crossover.service.response.BookResponse;

/**
Author : Praharsh Vasavda
Purpose : Service layer to connnect to DAO
**/
@Service(value="booksService")
public class BookService {
	
	private BookResponse response;
	
	/**
	 * 
	 * @param type
	 * @param text
	 * @return List
	 * @throws ServiceException
	 */
	public List<BookResponse> checkBooks(String type, String text) throws ServiceException{
		
		try {
			String baseuri = "http://localhost:8080/book-ws/search/{type}/{text}";
			Map<String, String> params = new HashMap<String, String>();
			params.put("type", type);
			params.put("text", text);
			RestTemplate restTemplate = new RestTemplate();
			List<LinkedHashMap> books = restTemplate.getForObject(baseuri, List.class,params);
			List<BookResponse> responseList = new ArrayList<BookResponse>();
			for(LinkedHashMap map : books){
				response = new BookResponse();
				response.setId(map.get("id").toString());
				response.setTitle(map.get("title").toString());
				response.setPublisher(map.get("publisher").toString());
				response.setAuthor(map.get("authors").toString());
				response.setDesc(map.get("desciption").toString());
				responseList.add(response);
			}
			return responseList;
		} catch (RestClientException e) {
			throw new ServiceException("CONNECTION_FAILED", e.getMessage());
		}
	}

}
