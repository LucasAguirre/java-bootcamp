package com.globant.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class Application implements WebMvcConfigurer {
	public static void main(String[] args) throws Exception {
		MainController.setUP();
		UserController.setUP();
		ProductController.setUP();
		SpringApplication.run(Application.class, args);
	}

}
