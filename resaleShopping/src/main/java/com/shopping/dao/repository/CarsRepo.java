package com.shopping.dao.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.shopping.model.Car;

/**
 * Dao interface for Car model
 * 
 * @author Anuja
 *
 */

@Repository
public interface CarsRepo extends MongoRepository<Car, Integer> {

	/* find car by wareHouse id */
	@Query("{'wareHouse.id': ?0}")
	List<Car> findByWareHouseId(int wareHouseId);

}
