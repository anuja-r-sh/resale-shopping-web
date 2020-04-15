package com.shopping.dao.mongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.shopping.dao.mongo.model.Car;

public interface CarsRepo extends MongoRepository<Car, Integer>{

	List<Car> getCars();

	
}
