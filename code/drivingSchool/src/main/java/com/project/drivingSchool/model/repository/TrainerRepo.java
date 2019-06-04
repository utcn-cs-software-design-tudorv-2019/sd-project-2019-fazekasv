package com.project.drivingSchool.model.repository;

import java.sql.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.project.drivingSchool.config.HibernateConfig;
import com.project.drivingSchool.model.entity.Course;
import com.project.drivingSchool.model.entity.Trainee;
import com.project.drivingSchool.model.entity.Trainer;
import com.project.drivingSchool.model.entity.User;
import com.project.drivingSchool.model.entity.Vehicle;

@Repository
public class TrainerRepo {

public Trainer findByUser(User user) {
		
		Session sessionObj = HibernateConfig.buildSessionFactory().openSession();
		Criteria cr = sessionObj.createCriteria(Trainer.class);
		cr.add(Restrictions.eq("user", user));
		List<Trainer> results = cr.list();
		
		sessionObj.close();
		
		return results.isEmpty()? null: results.get(0);
		
	}

public void updateinfo(Trainer trainer, String firstName, String lastName, String phone, String passFail) {
	
	Session sessionObj = HibernateConfig.buildSessionFactory().openSession();
	
	trainer.setFirstName(firstName);
	trainer.setLastName(lastName);
	trainer.setPhone(phone);
	trainer.setPassFail(Integer.parseInt(passFail));
	
	sessionObj.beginTransaction();
	sessionObj.update(trainer);
	sessionObj.getTransaction().commit();
	
	sessionObj.close();
}

public List<Vehicle> findVehicles() {
	
	Session sessionObj = HibernateConfig.buildSessionFactory().openSession();
	
	Criteria cr = sessionObj.createCriteria(Vehicle.class);
	List<Vehicle> results = cr.list();
	
	sessionObj.close();
	
	return results;
}

public List<Course> findCourses(Trainer trainer) {
	
	

	Session sessionObj = HibernateConfig.buildSessionFactory().openSession();
	Criteria cr = sessionObj.createCriteria(Course.class);
	cr.add(Restrictions.eq("trainer", trainer));
	List<Course> results = cr.list();
	
	//sessionObj.close();
	
	return results.isEmpty()? null: results;
}

public void addCourse(Trainer trainer, Date startDate) {
	
	Session sessionObj = HibernateConfig.buildSessionFactory().openSession();
	
	Course course = new Course();
	course.setStartDate(startDate);
	course.setTrainer(trainer);
	
	sessionObj.beginTransaction();
	sessionObj.save(course);
	sessionObj.getTransaction().commit();
	
	sessionObj.close();
	
}

public List<Trainee> findTraineesByCourse(Course c) {
	
	Session sessionObj = HibernateConfig.buildSessionFactory().openSession();
	Criteria cr = sessionObj.createCriteria(Trainee.class);
	cr.add(Restrictions.eq("course", c));
	List<Trainee> results = cr.list();
	
	//sessionObj.close();
	
	return results.isEmpty()? null: results;
}

public void registerTrainer(User user, Trainer trainer) {
	
Session sessionObj = HibernateConfig.buildSessionFactory().openSession();
	
	sessionObj.beginTransaction();
	sessionObj.save(user);
	sessionObj.getTransaction().commit();
	
	Criteria cr = sessionObj.createCriteria(User.class);
	cr.add(Restrictions.eq("email", user.getEmail()));
	List<User> results = cr.list();
	
	trainer.setUser(results.get(0));
	
	sessionObj.beginTransaction();
	sessionObj.save(trainer);
	sessionObj.getTransaction().commit();
	
	sessionObj.close();
	
	
}
}
