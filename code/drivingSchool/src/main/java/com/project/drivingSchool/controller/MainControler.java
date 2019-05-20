package com.project.drivingSchool.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class MainControler {

	
	 @RequestMapping("/")
	    public String index() {
	        return "Greetings from Spring Boot!";
	    }
	
}
