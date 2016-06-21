package com.crossover.dao.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;

/**
Author : Praharsh Vasavda
Purpose : Database configuration
**/
@Configuration
public class MongoConfig extends AbstractMongoConfiguration {
	
	/**
	 * Create MongoDbFactory
	 */
	 @Bean
	 public MongoDbFactory mongoDbFactory() throws Exception {
		return new SimpleMongoDbFactory(new MongoClient(), "Crossover");
	}

	 /**
	  * Create MongoTemplate
	  */
	 @Bean(name="mongoTemplate")
	 public MongoTemplate mongoTemplate() throws Exception {
		
		MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory());
		System.out.println("mongoTemplate"+mongoTemplate);		
		return mongoTemplate;
		
	}

	@Override
	protected String getDatabaseName() {
		// TODO Auto-generated method stub
		return "Crossover";
	}

	@Override
	public Mongo mongo() throws Exception {
		// TODO Auto-generated method stub
		return new MongoClient("127.0.0.1",27017);
	}

}
