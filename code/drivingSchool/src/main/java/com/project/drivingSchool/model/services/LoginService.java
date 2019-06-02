package com.project.drivingSchool.model.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.drivingSchool.model.entity.User;
import com.project.drivingSchool.model.repository.UserRepo;

@Service
public class LoginService {
	
	@Autowired
	UserRepo ur;
	
	public User login(String email) {
		
		return ur.findByEmail(email);
		
	}

}
