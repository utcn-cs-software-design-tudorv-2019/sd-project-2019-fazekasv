package com.project.drivingSchool.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.drivingSchool.model.entity.Course;
import com.project.drivingSchool.model.entity.Trainee;
import com.project.drivingSchool.model.entity.Trainer;
import com.project.drivingSchool.model.entity.User;
import com.project.drivingSchool.model.services.TraineeService;
import com.project.drivingSchool.model.services.TrainerService;

@Controller
public class RegisterController {

	@Autowired
	TrainerService ts;
	
	@Autowired
	TraineeService tes;
	
	@RequestMapping(value = { "/register" })
	public String register(Model model, HttpSession session) {
		
		return "register";
	}
	
	@RequestMapping(value = { "/registerTrainer" })
	public String registerTrainer(Model model, HttpSession session) {
		
		return "registerTrainer";
	}
	
	@RequestMapping(value = { "/registerTrainee" })
	public String registerTrainee(Model model, HttpSession session) {
		
		List<Course> courses = tes.findCourses();
		
		model.addAttribute("courses", courses);
		
		return "registerTrainee";
	}
	
	@PostMapping("/registerTrainer")
	public String getLoginInfo(HttpSession session, Model model, @RequestParam("username") String username,
			@RequestParam("password") String pass,
			@RequestParam("firstName") String fn,
			@RequestParam("lastName") String ln,
			@RequestParam("phone") String phone,
			@RequestParam("passFail") int passFail) {
		
		User user = new User();
		user.setEmail(username);
		user.setPass(pass);
		user.setTrainer(true);
		
		Trainer trainer = new Trainer();
		trainer.setFirstName(fn);
		trainer.setLastName(ln);
		trainer.setPhone(phone);
		trainer.setPassFail(passFail);
		
		ts.registerTrainer(user, trainer);
				
		return "redirect:login";
	}
	
	@PostMapping("/registerTrainee")
	public String getTraineeRegisterInfo(HttpSession session, Model model, @RequestParam("username") String username,
			@RequestParam("password") String pass,
			@RequestParam("name") String name,
			@RequestParam("age") int age,
			@RequestParam("address") String address,
			@RequestParam("courseElem") int courseElem) {
		
		Course course = tes.findCourseById(courseElem);
		
		
		User user = new User();
		user.setEmail(username);
		user.setPass(pass);
		user.setTrainer(false);
		
		Trainee trainee = new Trainee();
		trainee.setName(name);
		trainee.setAge(age);
		trainee.setAddress(address);
		trainee.setCourse(course);
		
		tes.registerTrainee(user, trainee);
				
		return "redirect:login";
	}
	
	
}
