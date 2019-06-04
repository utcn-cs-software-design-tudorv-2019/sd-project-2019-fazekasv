package com.project.drivingSchool.model.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.drivingSchool.model.repository.VehicleRepo;

@Service
public class VehicleService {

	@Autowired
	VehicleRepo vr;

	public void addVehicle(String brand, String modelName) {
		vr.addVehicle(brand, modelName);
	}
	
	
}
