package com.carolis.todo.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.carolis.todo.service.DBService;

@Configuration
@Profile("test")
public class TestConfig {

	@Autowired
	DBService dbservice;
	
	@Bean
	public boolean instance() {
		this.dbservice.dataBaseInstance();
		return true;
	}
}
