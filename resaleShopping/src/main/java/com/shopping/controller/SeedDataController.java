package com.shopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.services.Utility;

@RestController
public class SeedDataController {

	@Autowired
	private Utility utility;

	@PostMapping(value = "/loadSeedData")
	public String loadInitialData(@RequestBody String seedData) {

		utility.loadWareHouseData(seedData);

		return "success";

	}

}
