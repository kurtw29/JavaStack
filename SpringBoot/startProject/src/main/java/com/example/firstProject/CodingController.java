package com.example.firstProject;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/coding")
public class CodingController {
	@RequestMapping("")
	public String greeting() {
		return "Hello Coding Dojo2!";
	}
	
	@RequestMapping("/python")
	public String python() {
		return "Python/Django was awesome2!";
	}
	
	@RequestMapping("/java")
	public String java() {
		return "Java/Spring is better2!";
	}
}
