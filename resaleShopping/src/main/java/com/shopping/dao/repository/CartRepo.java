package com.shopping.dao.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.shopping.model.Cart;

@Repository
public interface CartRepo extends MongoRepository<Cart, Integer> {

	
}
