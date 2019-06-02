package com.project.drivingSchool.model.repository;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.project.drivingSchool.config.HibernateConfig;
import com.project.drivingSchool.model.entity.User;

@Repository
public class UserRepo {

	public User findByEmail(String email) {
		
		Session sessionObj = HibernateConfig.buildSessionFactory().openSession();
		Criteria cr = sessionObj.createCriteria(User.class);
		cr.add(Restrictions.eq("email", email));
		
		List<User> results = cr.list();
		
		return results.isEmpty()? null: results.get(0);
		
	}
	
}
