package com.project.drivingSchool.model.repository;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.project.drivingSchool.config.HibernateConfig;
import com.project.drivingSchool.model.entity.Vehicle;

@Repository
public class VehicleRepo {

	public void addVehicle(String brand, String modelName) {
		
		Session sessionObj = HibernateConfig.buildSessionFactory().openSession();
		
		Vehicle v = new Vehicle();
		v.setBrand(brand);
		v.setModel(modelName);
		
		sessionObj.beginTransaction();
		sessionObj.save(v);
		sessionObj.getTransaction().commit();
		
		sessionObj.close();
	}

}
