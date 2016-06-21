package com.crossover.ws.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.crossover.service.UserService;
import com.crossover.service.exception.ServiceException;
import com.crossover.ws.request.AuthenticateUser;
import com.crossover.ws.response.UserResponse;


/**
Author : Praharsh Vasavda
Purpose : Provides user related service
**/

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	private UserResponse userResponse;
	
	/**
	 * Purpose : Checks for authentication of the user
	 * @param request
	 * @return Object
	 * **/
	
	@RequestMapping(value="/authenticate", method=RequestMethod.POST)
	@ResponseBody public Object authenticate(@RequestBody AuthenticateUser request){
		try {
			@SuppressWarnings("unused")
			String status = userService.validateUser(request.getUsername(), request.getPassword());
			userResponse = new UserResponse(status, request.getUsername());
			return userResponse;
		} catch (ServiceException e) {
			userResponse = new UserResponse("FAILURE",e.getErrorCode() , e.getErrorMessage());
			return userResponse;
		}
		
	}
}
