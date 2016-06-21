package com.crossover.service;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import com.crossover.dao.impl.MongoDAOImpl;

@TestExecutionListeners( { DependencyInjectionTestExecutionListener.class })
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/testSpringConfig.xml"})
public class UserServiceTest {
	
	@Mock
	private MongoDAOImpl daoImpl;
	@InjectMocks
	private UserService test;
	
	/*s*/

}
