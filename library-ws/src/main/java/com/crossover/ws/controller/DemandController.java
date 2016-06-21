package com.crossover.ws.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.crossover.dao.entity.Demand;
import com.crossover.service.DemandService;
import com.crossover.service.exception.ServiceException;
import com.crossover.ws.exception.PublisherWSException;
import com.crossover.ws.request.DemandRequest;
import com.crossover.ws.response.UserResponse;

/**
Author : Praharsh Vasavda
Purpose : Provides service to user to raise a demand for the book and previously raised demands
**/

@Controller
public class DemandController {
	
	@Autowired
	private DemandService demandService;
	
	private UserResponse userResponse;
	
	
	/**
	 * Purpose : Provides service to user to raise a demand for the book
	 * @param request
	 * @return Object
	 */
	@RequestMapping(value="/raise", method=RequestMethod.POST)
	@ResponseBody public Object raise(@RequestBody DemandRequest request){
		try {
			@SuppressWarnings("unused")
			String status = demandService.insertDemand(request.getUsername(), request.getBookid());
			userResponse = new UserResponse(status, request.getUsername());
			return userResponse;
		} catch (ServiceException e) {
			PublisherWSException exception = new PublisherWSException("FAILURE",e.getErrorCode() , e.getErrorMessage());
			return exception;
		}
		
	}
	
	/**
	 * Purpose: find previously raised demands
	 * @param String
	 * @return Object
	 * **/
	@RequestMapping(value="/retrieve/{username}", method=RequestMethod.GET)
	@ResponseBody public Object retrieve(@PathVariable String username){
		try {
			@SuppressWarnings("unused")
			List<Demand> demandList = demandService.fetchDemands(username);
			return demandList;
		} catch (ServiceException e) {
			PublisherWSException exception = new PublisherWSException("FAILURE",e.getErrorCode() , e.getErrorMessage());
			return exception;
		}
		
	}

}
