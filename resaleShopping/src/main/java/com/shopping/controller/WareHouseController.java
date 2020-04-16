package com.shopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.model.WareHouse;
import com.shopping.services.WareHouseService;

/**
 * Controller class for WareHouse
 * 
 * @author Anuja
 *
 */
@RestController
public class WareHouseController {

	@Autowired
	private WareHouseService wareHouseService;

	@GetMapping("/wareHouses")
	@CrossOrigin(origins = "*")
	public List<WareHouse> getListOfWareHouses() {
		return wareHouseService.getListOfWareHouses();
	}

}
