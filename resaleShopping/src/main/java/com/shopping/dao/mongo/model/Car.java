package com.shopping.dao.mongo.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Document
public class Car {
	@Id
	private long _id;
	private String make;
	private String model;
	private long year_model;
	private Double price;
	private boolean licensed;
	private Date date_added = null;
	private String carLocation;
	private WareHouse wareHouse;

	public Car(long _id, String make, String model, long year_model, Double price, boolean licensed, Date date_added,
			String carLocation, WareHouse wareHouse) {
		super();
		this._id = _id;
		this.make = make;
		this.model = model;
		this.year_model = year_model;
		this.price = price;
		this.licensed = licensed;
		this.date_added = date_added;
		this.carLocation = carLocation;
		this.wareHouse = wareHouse;
	}

	public long get_id() {
		return _id;
	}

	public void set_id(long _id) {
		this._id = _id;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public long getYear_model() {
		return year_model;
	}

	public void setYear_model(long year_model) {
		this.year_model = year_model;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public boolean isLicensed() {
		return licensed;
	}

	public void setLicensed(boolean licensed) {
		this.licensed = licensed;
	}

	public Date getDate_added() {
		return date_added;
	}

	public void setDate_added(Date date_added) {
		this.date_added = date_added;
	}

	public String getLocation() {
		return carLocation;
	}

	public void setLocation(String location) {
		this.carLocation = location;
	}

	public WareHouse getWareHouse() {
		return wareHouse;
	}

	public void setWareHouse(WareHouse wareHouse) {
		this.wareHouse = wareHouse;
	}

}
