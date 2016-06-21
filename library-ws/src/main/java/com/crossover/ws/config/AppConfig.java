package com.crossover.ws.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
Author : Praharsh Vasavda
Purpose : Provides Spring configuration
**/

@Configuration 
@ComponentScan("com.crossover") 
@EnableWebMvc   
public class AppConfig {  

} 
