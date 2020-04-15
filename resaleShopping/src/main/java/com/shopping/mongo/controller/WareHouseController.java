package com.shopping.mongo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.mongo.model.WareHouse;
import com.shopping.mongo.repository.WareHouseRepo;

/**
 * Controller class for WareHouse
 * 
 * @author Anuja
 *
 */
@RestController
public class WareHouseController {

	@Autowired
	WareHouseRepo wareHouseRepo;

	@GetMapping("/wareHouses")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<WareHouse> getListOfWareHouses() {
		return wareHouseRepo.findAll();
	}

}
