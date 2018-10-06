package com.example.firstProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController	
public class StartProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(StartProjectApplication.class, args);
	}

	@RequestMapping("/")
	public String hello() {
		return "Hello client! How are you doing?";
	}
	
	@RequestMapping("/random")
	public String comment() {
		return "Spring Boot is great! so easy to just respond with strings!";
	}
}
