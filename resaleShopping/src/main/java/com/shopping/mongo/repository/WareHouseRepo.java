package com.shopping.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.shopping.mongo.model.WareHouse;

public interface WareHouseRepo extends MongoRepository<WareHouse, Integer> {
	
	

}
