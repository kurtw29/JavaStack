package com.example.firstProject;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloHuman {
	@RequestMapping("/human/")
	public String greet(@RequestParam(value="firstName", required=false) String firstName, @RequestParam(value="lastName", required=false) String lastName) {
		if(firstName != null && lastName != null) {
			return "Hello "+firstName.substring(0, 1).toUpperCase()+firstName.substring(1).toLowerCase()+" "+lastName.substring(0, 1).toUpperCase()+lastName.substring(1).toLowerCase()+"!";
		}else if(firstName != null && lastName == null) {
			return "Hello "+firstName.substring(0, 1).toUpperCase()+firstName.substring(1).toLowerCase()+"!";
		}else {
			return "Hello human!";
		}
	}
}
