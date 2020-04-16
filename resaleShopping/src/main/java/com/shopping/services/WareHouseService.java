package com.shopping.services;

import java.util.List;

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
}
