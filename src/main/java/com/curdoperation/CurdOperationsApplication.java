package com.curdoperation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication //auto configuration & more uses
/*
Indicates a configuration class that declares one or more @Bean methods and also triggers auto-configuration and component scanning.
This is a convenience annotation that is equivalent to declaring @Configuration, @EnableAutoConfiguration and @ComponentScan.
*/
public class CurdOperationsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurdOperationsApplication.class, args);
	}

}
