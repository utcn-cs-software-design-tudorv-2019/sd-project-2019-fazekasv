package com.project.drivingSchool.model.repository;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.drivingSchool.config.HibernateConfig;
import com.project.drivingSchool.model.entity.Course;
import com.project.drivingSchool.model.entity.Trainee;
import com.project.drivingSchool.model.entity.Trainer;
import com.project.drivingSchool.model.entity.User;

@Repository
public class TraineeRepo {

	public List<Course> findCourses() {

		Session sessionObj = HibernateConfig.buildSessionFactory().openSession();
		Criteria cr = sessionObj.createCriteria(Course.class);
		List<Course> results = cr.list();
		
		return results.isEmpty()? null: results;
	}

	public void registerTrainee(User user, Trainee trainee) {
		
		Session sessionObj = HibernateConfig.buildSessionFactory().openSession();
		
		sessionObj.beginTransaction();
		sessionObj.save(user);
		sessionObj.getTransaction().commit();
		
		Criteria cr = sessionObj.createCriteria(User.class);
		cr.add(Restrictions.eq("email", user.getEmail()));
		List<User> results = cr.list();
		
		trainee.setUser(results.get(0));
		
		sessionObj.beginTransaction();
		sessionObj.save(trainee);
		sessionObj.getTransaction().commit();
		
		sessionObj.close();
		
	}

	public Course findCourseById(int courseElem) {
		Session sessionObj = HibernateConfig.buildSessionFactory().openSession();
		Criteria cr = sessionObj.createCriteria(Course.class);
		cr.add(Restrictions.eq("courseId", courseElem));
		List<Course> results = cr.list();
		
		sessionObj.close();
		
		return results.isEmpty()? null: results.get(0);
	}

	public Trainee findByUser(User user) {
		Session sessionObj = HibernateConfig.buildSessionFactory().openSession();
		List<Trainee> results = null;
		try {
		Criteria cr = sessionObj.createCriteria(Trainee.class);
		cr.add(Restrictions.eq("user", user));
		results = cr.list();
		} finally {
			sessionObj.close();
		}
//		sessionObj.close();
		
		return results.isEmpty()? null: results.get(0);
		
	}

	public void updateInfo(Trainee trainee) {
		
		Session sessionObj = HibernateConfig.buildSessionFactory().openSession();
		
		sessionObj.beginTransaction();
		sessionObj.update(trainee);
		sessionObj.getTransaction().commit();
		
//		sessionObj.close();
		
	}
	
}
