package com.ouriques.serviceToService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class ServiceToServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceToServiceApplication.class, args);
	}

}

