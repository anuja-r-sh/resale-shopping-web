package com.shopping.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;

import com.shopping.dao.repository.CarsRepo;
import com.shopping.model.Car;

@Service
public class CarService {

	@Autowired
	private CarsRepo carRepo;

	public List<Car> getListOfCars() {

		return carRepo.findAll(Sort.by(Order.asc("dateAdded")));

	}
}
