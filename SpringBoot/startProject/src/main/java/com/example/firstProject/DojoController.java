package com.example.firstProject;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DojoController {
		@RequestMapping("/{dojo}")
	public String dojo(@PathVariable("dojo") String dojo) {
		if(dojo.equals("dojo")) {
			return "The "+dojo+" is awesome!";			
		}else if(dojo.equals("burbank-dojo")) {
			return "Burbank Dojo is located in Southern California";
		}else if(dojo.equals("san-jose")) {
			return "SJ dojo is the headquarters";
		}
		return "Hello, there are specific url that routes to a paricular response";
	}
}
