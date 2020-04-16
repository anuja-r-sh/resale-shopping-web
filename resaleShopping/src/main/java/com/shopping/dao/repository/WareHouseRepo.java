package com.shopping.dao.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.shopping.model.WareHouse;

public interface WareHouseRepo extends MongoRepository<WareHouse, Integer> {
	
	

}
