package com.project.drivingSchool.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.drivingSchool.model.entity.Trainee;
import com.project.drivingSchool.model.entity.User;
import com.project.drivingSchool.model.services.ExamService;

@Controller
public class ExamController {

	@Autowired
	ExamService es;
	
	static int points = 0;
	static int mistakes = 0;
	static List<Integer> results = null;
	
 
	@RequestMapping(value = { "/exam" })
	public String login(Model model, HttpSession session) {
		
		model.addAttribute("score", points);
		model.addAttribute("mistake", mistakes);
		model.addAttribute("question", es.getQuestion());
		model.addAttribute("a", "aaaaa");
		model.addAttribute("b", "bb");
		model.addAttribute("c", "ccccc");

		return "exam";
	}
	
	@PostMapping("/answerQuestion")
	public String getLoginInfo(HttpSession session, Model model,
			@RequestParam(value = "a", required=false) boolean a,
			@RequestParam(value = "b", required=false) boolean b,
			@RequestParam(value = "c", required=false) boolean c){

		System.out.println(a +"" +  b +""+ c);
		
		this.points++;
		
		if (points == 5) {
			return "succes";
		}
		if (mistakes == 2) {
			return "fail";
		}
		
		return "redirect:exam";
	}
	
	@RequestMapping(value = { "/succes" })
	public String succes(Model model, HttpSession session) {

		return "succes";
	}
	
	
	
}
