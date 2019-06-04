package com.project.drivingSchool.controller;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.project.drivingSchool.model.entity.Vehicle;
import com.project.drivingSchool.model.services.TrainerService;
import com.project.drivingSchool.model.services.VehicleService;

@Controller
public class TrainerController {

	@Autowired
	TrainerService ts;
	@Autowired
	VehicleService vs;
	

	@RequestMapping(value = { "/trainer" })
	public String login(Model model, HttpSession session) {

		User user = (User) session.getAttribute("user");

		Trainer trainer = ts.findByUser(user);

		model.addAttribute("firstName", trainer.getFirstName());
		model.addAttribute("lastName", trainer.getLastName());
		model.addAttribute("phone", trainer.getPhone());
		model.addAttribute("passRate", trainer.getPassFail());
		
		List<Vehicle> vehicles = ts.findVehicles();
		
		List<Course> courses = ts.findCourses(trainer);
		Map<Course,List<Trainee>> studentsByCourse = new HashMap<>();
		courses.forEach(c -> {
			List<Trainee> trainees = ts.findTraineesByCourse(c);
			studentsByCourse.put(c, trainees);
		});
		model.addAttribute("vehicles", vehicles);
		model.addAttribute("courses", studentsByCourse);

		return "trainer";
	}

	@PostMapping("/updateTrainer")
	public String getLoginInfo(HttpSession session, Model model, @RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName, @RequestParam("phone") String phone,
			@RequestParam("PassRate") String passFail) {

		User user = (User) session.getAttribute("user");
		Trainer trainer = ts.findByUser(user);
		
		ts.updateInfo(trainer, firstName, lastName, phone, passFail);
		
		model.addAttribute("firstName", trainer.getFirstName());
		model.addAttribute("lastName", trainer.getLastName());
		model.addAttribute("phone", trainer.getPhone());
		model.addAttribute("passRate", trainer.getPassFail());

		return "trainer";
	}
	
	@PostMapping("/addVehicle")
	public String getLoginInfo(HttpSession session, Model model, @RequestParam("brand") String brand,
			@RequestParam("model") String modelName) {
		
		vs.addVehicle(brand,modelName);
		
		return "redirect:trainer";
	}
	
	@PostMapping("/addCourse")
	public String addCourse(HttpSession session, Model model, @RequestParam("startDate") Date startDate) {
		
		User user = (User) session.getAttribute("user");
		Trainer trainer = ts.findByUser(user);
		ts.addCourse(trainer, startDate);
		
		return "redirect:trainer";
	}
}
