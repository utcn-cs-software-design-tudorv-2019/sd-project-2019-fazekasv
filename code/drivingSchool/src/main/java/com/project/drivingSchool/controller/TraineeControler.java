package com.project.drivingSchool.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.drivingSchool.model.entity.Exam;
import com.project.drivingSchool.model.entity.Trainee;
import com.project.drivingSchool.model.entity.User;
import com.project.drivingSchool.model.services.TraineeService;

@Controller
public class TraineeControler {
	
	@Autowired
	TraineeService ts;
	
	@RequestMapping(value = { "/trainee" })
	public String login(Model model, HttpSession session) {

		User user = (User) session.getAttribute("user");
		
		Trainee trainee = ts.findByUser(user);
		List<Exam> exams = ts.findExams();
		model.addAttribute("name", trainee.getName());
		model.addAttribute("age", trainee.getAge());
		model.addAttribute("address", trainee.getAddress());
		
		model.addAttribute("courseDate", trainee.getCourse() != null? trainee.getCourse().getStartDate(): null);
		
		model.addAttribute("exams", exams);
		
		
		return "trainee";
	}
	
	@PostMapping("/updateTrainee")
	public String getLoginInfo(HttpSession session, Model model, @RequestParam("name") String name,
			@RequestParam("age") int age, @RequestParam("address") String address) {

		User user = (User) session.getAttribute("user");
		Trainee trainee = ts.findByUser(user);
		
		ts.updateInfo(trainee, name, age, address);
		
		model.addAttribute("name", trainee.getName());
		model.addAttribute("age", trainee.getAge());
		model.addAttribute("address", trainee.getAddress());

		return "redirect:trainee";
	}
}
