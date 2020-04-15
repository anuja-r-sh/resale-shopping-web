package com.shopping.dao.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.shopping.dao.mongo.model.WareHouse;

public interface WareHouseRepo extends MongoRepository<WareHouse, Integer> {
	
	

}
