package com.shopping.dao.mongo.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Car {
	@Id
	private int _id;
	private String make;
	private String model;
	private int year_model;
	private double price;
	private boolean licensed;
	private String date_added = null;

	public Car(int _id, String make, String model, int year_model, double price, boolean licensed, String date_added) {
		super();
		this._id = _id;
		this.make = make;
		this.model = model;
		this.year_model = year_model;
		this.price = price;
		this.licensed = licensed;
		this.date_added = date_added;
	}

	public int get_id() {
		return _id;
	}

	public void set_id(int _id) {
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

	public int getYear_model() {
		return year_model;
	}

	public void setYear_model(int year_model) {
		this.year_model = year_model;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public boolean isLicensed() {
		return licensed;
	}

	public void setLicensed(boolean licensed) {
		this.licensed = licensed;
	}

	public String getDate_added() {
		return date_added;
	}

	public void setDate_added(String date_added) {
		this.date_added = date_added;
	}

}
