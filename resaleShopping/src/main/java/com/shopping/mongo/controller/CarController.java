package com.shopping.mongo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.mongo.model.Car;
import com.shopping.mongo.repository.CarsRepo;

/**
 * Controller class for Car Dao
 * 
 * @author Anuja
 *
 */
@RestController
public class CarController {

	@Autowired
	private CarsRepo carRepo;

	@GetMapping("/cars")
	@CrossOrigin(origins = "*")
	public List<Car> getListOfCars() {
		return carRepo.findAll();
	}

	@GetMapping("/cars/{wareHouseId}")
	@CrossOrigin(origins = "*")
	public List<Car> getCarsByWareHouse(@PathVariable int wareHouseId) {
		return carRepo.findByWareHouseId(wareHouseId);
	}

}
