package com.globant.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class RestApplication implements WebMvcConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(RestApplication.class, args);
	}

}
