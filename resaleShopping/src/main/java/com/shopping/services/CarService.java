package com.shopping.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.shopping.dao.repository.CarsRepo;
import com.shopping.model.Car;

@Service
public class CarService {

	@Autowired
	private CarsRepo carRepo;

	
	public List<Car> getListOfCars() {
		return carRepo.findAll();
	}

	public List<Car> getCarsByWareHouse(@PathVariable int wareHouseId) {
		return carRepo.findByWareHouseId(wareHouseId);
	}

}
