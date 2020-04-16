package com.shopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.dao.repository.WareHouseRepo;
import com.shopping.model.WareHouse;

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
	@CrossOrigin(origins = "*")
	public List<WareHouse> getListOfWareHouses() {
		return wareHouseRepo.findAll();
	}

}
