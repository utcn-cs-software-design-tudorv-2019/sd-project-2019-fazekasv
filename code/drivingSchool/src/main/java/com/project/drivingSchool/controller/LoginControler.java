package com.project.drivingSchool.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class LoginControler {

	
	 @RequestMapping("/")
	 public ModelAndView login() {
			ModelAndView mv = new ModelAndView("login");
			mv.addObject("title", "Add Product");
			mv.addObject("userClickManageProd", true);	
			
			return mv;
		}
	
}
