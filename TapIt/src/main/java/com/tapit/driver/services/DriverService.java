package com.tapit.driver.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.tapit.driver.models.Driver;
import com.tapit.driver.repositories.DriverRepository;

public class DriverService {

	@Autowired
	private DriverRepository driverRepository;
	
	
	public Driver registerDriver() {		
		return null;
	}
}
