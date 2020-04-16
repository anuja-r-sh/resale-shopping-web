package com.shopping.dao.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.shopping.model.WareHouse;

public interface WareHouseRepo extends MongoRepository<WareHouse, Integer> {
	
	@Query("{'carList._id':?0}")
	WareHouse findWareHouse(int carId);
}
