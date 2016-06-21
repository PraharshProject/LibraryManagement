package com.crossover.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crossover.dao.entity.Demand;
import com.crossover.dao.exception.DAOException;
import com.crossover.dao.impl.MongoDAOImpl;
import com.crossover.service.exception.ServiceException;

/**
Author : Praharsh Vasavda
Purpose : Demand service to check for demands
**/
@Service(value="demandService")
public class DemandService {
	
	@Autowired
	private MongoDAOImpl daoImpl;
	
	/**
	 * 
	 * @param username
	 * @param bookid
	 * @return Status
	 * @throws ServiceException
	 */
	public String insertDemand(String username, String bookid) throws ServiceException{
		
		try {
			String bookname = daoImpl.findBookName(bookid);
			Calendar currentDate = Calendar.getInstance();
			SimpleDateFormat formatter= new SimpleDateFormat("yyyy/MMM/dd");
			String dateNow = formatter.format(currentDate.getTime());
			Demand demand = new Demand(username,bookname,dateNow,"Demand Raised");
			daoImpl.insertDemand(demand);
			return "Success";
		} catch (DAOException e) {
			throw new ServiceException(e.getErrorCode(), e.getErrorMessage());
		}
	}

	public List<Demand> fetchDemands(String username) throws ServiceException{
		try{
			List<Demand> demandList = daoImpl.findDemands(username);
			return demandList;
		}catch(DAOException e){
			throw new ServiceException(e.getErrorCode(), e.getErrorMessage());
		}
	}
}
