package com.project.drivingSchool.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RegisterController {

	
	@RequestMapping(value = { "/register" })
	public String login(Model model, HttpSession session) {
		
		return "register";
	}
}
