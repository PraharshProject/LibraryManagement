package com.crossover.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crossover.dao.entity.User;
import com.crossover.dao.exception.DAOException;
import com.crossover.dao.impl.MongoDAOImpl;
import com.crossover.service.exception.ServiceException;

/**
Author : Praharsh Vasavda
Purpose : Service to connect to User Db
**/
@Service(value="userService")
public class UserService {
	
	@Autowired
	private MongoDAOImpl daoImpl;
	
	private User user;
	
	/**
	 * 
	 * @param username
	 * @param password
	 * @return Status
	 * @throws ServiceException
	 */
	public String validateUser(String username, String password) throws ServiceException{
		try {
			user = daoImpl.searchUser(username);
			if(password.equals(user.getPassword())){
				return "Success";
			}else{
				return "Failure";
			}
		} catch (DAOException e) {
			throw new ServiceException(e.getErrorCode(), e.getErrorMessage());
		}
	}
}
