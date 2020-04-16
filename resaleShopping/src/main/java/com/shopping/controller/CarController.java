package com.shopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.model.Car;
import com.shopping.services.CarService;

/**
 * Controller class for Car Dao
 * 
 * @author Anuja
 *
 */
@RestController
public class CarController {

	@Autowired
	private CarService carService;

	@GetMapping("/cars")
	@CrossOrigin(origins = "*")
	public List<Car> getListOfCars() {
		return carService.getListOfCars();
	}

	@GetMapping("/cars/{wareHouseId}")
	@CrossOrigin(origins = "*")
	public List<Car> getCarsByWareHouse(@PathVariable int wareHouseId) {
		return carService.getCarsByWareHouse(wareHouseId);
	}

}
