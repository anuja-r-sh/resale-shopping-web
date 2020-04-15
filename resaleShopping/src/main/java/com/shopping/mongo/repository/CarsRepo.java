package com.shopping.mongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.shopping.mongo.model.Car;

/**
 * Dao interface for Car model
 * 
 * @author Anuja
 *
 */
public interface CarsRepo extends MongoRepository<Car, Integer> {

	/* find car by wareHouse id */
	@Query("{'wareHouse.id': ?0}")
	List<Car> findByWareHouseId(int wareHouseId);

}
