package com.project.drivingSchool.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TraineeControler {
	
	@RequestMapping(value = { "/trainee" })
	public String login(Model model, HttpSession session) {

		System.out.println("user"+ session.getAttribute("user").toString());
		return "trainee";
	}
}
