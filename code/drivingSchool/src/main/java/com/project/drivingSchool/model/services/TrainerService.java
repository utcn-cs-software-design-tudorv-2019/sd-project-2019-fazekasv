package com.project.drivingSchool.model.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.drivingSchool.model.entity.Trainer;
import com.project.drivingSchool.model.entity.User;
import com.project.drivingSchool.model.repository.TrainerRepo;

@Service
public class TrainerService {

	@Autowired
	TrainerRepo tr;

	public Trainer findByUser(User user) {

		return tr.findByUser(user);

	}
}
