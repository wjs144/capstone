package com.controller.endpoint;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.database") // where to look for the DB connectors
@EntityScan( basePackages = {"com.database"} ) //Where to look for entitity classes
@ComponentScan({"com.manager","com.controller.endpoint"}) // where to look for components
public class ApplicationEntry {

	public static void main(String[] args) {
		SpringApplication.run(ApplicationEntry.class, args);
	}

}