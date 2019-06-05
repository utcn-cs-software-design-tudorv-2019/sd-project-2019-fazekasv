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
	
	boolean aa,bb,cc;
	
 
	@RequestMapping(value = { "/exam" })
	public String login(Model model, HttpSession session) {
		
		model.addAttribute("score", points);
		model.addAttribute("mistake", mistakes);
		String question = es.getQuestion();
		model.addAttribute("question", question);
		model.addAttribute("a", es.getAnswers().get(0));
		model.addAttribute("b", es.getAnswers().get(1));
		model.addAttribute("c", es.getAnswers().get(2));
		aa = es.getCorectResponse(question, es.getAnswers().get(0));
		bb = es.getCorectResponse(question, es.getAnswers().get(1));
		cc = es.getCorectResponse(question, es.getAnswers().get(2));

		return "exam";
	}
	
	@PostMapping("/answerQuestion")
	public String getLoginInfo(HttpSession session, Model model,
			@RequestParam(value = "a", required=false) boolean a,
			@RequestParam(value = "b", required=false) boolean b,
			@RequestParam(value = "c", required=false) boolean c){

		
		if (a == aa && b == bb && c ==cc) {
		this.points++;
		} else {
			mistakes++;
		}
		if (points == 5) {
			points = 0;
			mistakes = 0;
			return "succes";
		}
		if (mistakes == 2) {
			points = 0;
			mistakes = 0;
			return "fail";
		}
		
		return "redirect:exam";
	}
	
	@RequestMapping(value = { "/succes" })
	public String succes(Model model, HttpSession session) {

		return "succes";
	}
	
	
	
}
