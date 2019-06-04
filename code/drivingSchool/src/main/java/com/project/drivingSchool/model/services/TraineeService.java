package com.project.drivingSchool.model.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.drivingSchool.model.entity.Course;
import com.project.drivingSchool.model.entity.Trainee;
import com.project.drivingSchool.model.entity.User;
import com.project.drivingSchool.model.repository.TraineeRepo;

@Service
public class TraineeService {

	
	@Autowired
	TraineeRepo tr;

	public List<Course> findCourses() {
		return tr.findCourses();
	}

	public void registerTrainee(User user, Trainee trainee) {

		tr.registerTrainee(user, trainee);
		
	}

	public Course findCourseById(int courseElem) {
		return tr.findCourseById(courseElem);
	}

	public Trainee findByUser(User user) {
		return tr.findByUser(user);
	}

	public void updateInfo(Trainee trainee, String name, int age, String address) {
		trainee.setName(name);
		trainee.setAge(age);
		trainee.setAddress(address);
		tr.updateInfo(trainee);
	}
}
