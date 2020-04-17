package com.shopping.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping.dao.repository.WareHouseRepo;
import com.shopping.model.WareHouse;

@Service
public class WareHouseService {

	@Autowired
	WareHouseRepo wareHouseRepo;

	public List<WareHouse> getListOfWareHouses() {
		return wareHouseRepo.findAll();
	}

	public Map<String, Object> getWareHouseDetails(int carId) {
		HashMap<String, Object> wareHouseDetails = new HashMap<>();
		WareHouse wareHouse = wareHouseRepo.findWareHouse(carId);
		wareHouseDetails.put("id", wareHouse.getId());
		wareHouseDetails.put("location", wareHouse.getLocation());
		wareHouseDetails.put("name", wareHouse.getName());

		return wareHouseDetails;

	}
}
