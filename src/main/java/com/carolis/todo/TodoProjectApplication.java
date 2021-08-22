package com.carolis.todo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TodoProjectApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(TodoProjectApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	}

}
