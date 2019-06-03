package com.project.drivingSchool.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.drivingSchool.model.entity.User;
import com.project.drivingSchool.model.services.TrainerService;

@Controller
public class TrainerController {

	@Autowired
	TrainerService ts;
	
	@RequestMapping(value = { "/trainer" })
	public String login(Model model, HttpSession session) {

		User user = (User) session.getAttribute("user");
		
		System.out.println("The user before check " + user.toString());
		
		ts.findByUser(user);
		
		return "trainee";
	}
}
