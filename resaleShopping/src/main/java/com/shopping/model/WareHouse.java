package com.shopping.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class WareHouse {

	@Id
	private int id;
	private String name;
	private Location location;
	private List<Car> carList;

	public WareHouse(int id, Location location, String name, List<Car> carList) {
		super();
		this.id = id;
		this.location = location;
		this.name = name;
		this.setCarList(carList);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Car> getCarList() {
		return carList;
	}

	public void setCarList(List<Car> carList) {
		this.carList = carList;
	}

	@Override
	public String toString() {
		return "WareHouse [id=" + id + ", location=" + location + ", name=" + name + ", carList=" + carList + "]";
	}
	
	

}
