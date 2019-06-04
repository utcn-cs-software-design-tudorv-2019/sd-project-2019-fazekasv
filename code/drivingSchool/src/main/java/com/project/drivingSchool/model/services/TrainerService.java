package com.project.drivingSchool.model.services;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.drivingSchool.model.entity.Course;
import com.project.drivingSchool.model.entity.Trainee;
import com.project.drivingSchool.model.entity.Trainer;
import com.project.drivingSchool.model.entity.User;
import com.project.drivingSchool.model.entity.Vehicle;
import com.project.drivingSchool.model.repository.TrainerRepo;

@Service
public class TrainerService {

	@Autowired
	TrainerRepo tr;

	public Trainer findByUser(User user) {

		return tr.findByUser(user);

	}

	public void updateInfo(Trainer trainer, String firstName, String lastName, String phone, String passFail) {

		tr.updateinfo(trainer,firstName, lastName, phone, passFail);
		
	}

	public List<Vehicle> findVehicles() {
		return tr.findVehicles();
	}

	public List<Course> findCourses(Trainer trainer) {
		return tr.findCourses(trainer);
	}

	public void addCourse(Trainer trainer, Date startDate) {

		tr.addCourse(trainer, startDate);
	}

	public List<Trainee> findTraineesByCourse(Course c) {
		return tr.findTraineesByCourse(c);
	}

	public void registerTrainer(User user, Trainer trainer) {
		
		tr.registerTrainer(user, trainer);
		
	}
}
