package com.project.drivingSchool.model.repository;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.project.drivingSchool.config.HibernateConfig;
import com.project.drivingSchool.model.entity.Trainer;
import com.project.drivingSchool.model.entity.User;

@Repository
public class TrainerRepo {

public Trainer findByUser(User user) {
		
		Session sessionObj = HibernateConfig.buildSessionFactory().openSession();
		Criteria cr = sessionObj.createCriteria(Trainer.class);
		cr.add(Restrictions.eq("user", user));
		System.out.println(user.toString());
		System.out.println("hereeeeeeeeeeeeee");
		List<Trainer> results = cr.list();
		
		System.out.println(results.toString());
		
		return results.isEmpty()? null: results.get(0);
		
	}
}
