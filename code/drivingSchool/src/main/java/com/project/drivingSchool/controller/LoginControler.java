package com.project.drivingSchool.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.drivingSchool.model.entity.User;
import com.project.drivingSchool.model.services.LoginService;

@Controller
public class LoginControler {

	String error;
	String name = "", pass = "";
	boolean remember = true;

	@Autowired
	LoginService ls;

	@RequestMapping(value = { "/login" })
	public String login(Model mv) {
		mv.addAttribute("name", name);
		mv.addAttribute("pass", pass);
		mv.addAttribute("error", error);

		return "login";
	}

	@PostMapping("/login")
	public String getLoginInfo(HttpSession session,Model mv, @RequestParam("username") String name, @RequestParam("password") String pass) {

		User user = ls.login(name);
		
		if (pass.equals("") || name.equals("") || user == null) {
			this.error = "Username or password incorrect";
			this.name = name;
			this.pass = pass;
			mv.addAttribute("name", this.name);
			mv.addAttribute("pass", this.pass);
			mv.addAttribute("error", this.error);
			
			return "login";
		} else {
			this.error = "";
			mv.addAttribute("error", this.error);
			session.setAttribute("user", user);
			if (user.isTrainer()) {
				
				return "redirect:trainer";
				
				
			} else {
				
				return "redirect:trainee";
			}
		}

	}
	

}
