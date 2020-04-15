package com.shopping.dao.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.shopping.dao.mongo.model.Car;

public interface CarsRepo extends MongoRepository<Car, Integer> {

}
