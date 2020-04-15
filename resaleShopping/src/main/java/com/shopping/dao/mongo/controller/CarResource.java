package com.shopping.dao.mongo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.dao.mongo.model.Car;
import com.shopping.dao.mongo.repository.CarsRepo;

/**
 * Controller class for Car Dao
 * 
 * @author Anuja
 *
 */
@RestController
public class CarResource {

	@Autowired
	private CarsRepo carRepo;

	@GetMapping("/cars")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<Car> getListOfCars() {
		return carRepo.findAll();
	}

	@GetMapping("/cars/{wareHouseId}")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<Car> getCarsByWareHouse(@PathVariable int wareHouseId) {
		return carRepo.findByWareHouseId(wareHouseId);
	}

}
