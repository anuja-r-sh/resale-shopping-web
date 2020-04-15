package com.shopping.dao.mongo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.dao.mongo.model.Car;
import com.shopping.dao.mongo.repository.CarsRepo;
import com.shopping.dao.mongo.repository.WareHouseRepo;

@RestController
public class CarResource {

	@Autowired
	WareHouseRepo wareHouseRepo;

	@Autowired
	CarsRepo carRepo;

	@GetMapping("/cars")
	public List<Car> getListOfCars() {
		return carRepo.findAll();
	}
	
	

}
