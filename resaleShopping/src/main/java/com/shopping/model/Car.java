package com.shopping.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Car {
	@Id
	private long id;
	private String make;
	private String model;
	private long yearModel;
	private Double price;
	private boolean licensed;
	private Date dateAdded = null;
	private String carLocation;

	public Car(long id, String make, String model, long yearModel, Double price, boolean licensed, Date dateAdded,
			String carLocation) {
		super();
		this.id = id;
		this.make = make;
		this.model = model;
		this.yearModel = yearModel;
		this.price = price;
		this.licensed = licensed;
		this.dateAdded = dateAdded;
		this.carLocation = carLocation;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public long getYearModel() {
		return yearModel;
	}

	public void setYearModel(long yearModel) {
		this.yearModel = yearModel;
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

	public Date getDateAdded() {
		return dateAdded;
	}

	public void setDateAdded(Date dateAdded) {
		this.dateAdded = dateAdded;
	}

	public String getLocation() {
		return carLocation;
	}

	public void setLocation(String location) {
		this.carLocation = location;
	}

	@Override
	public String toString() {
		return "Car [_id=" + id + ", make=" + make + ", model=" + model + ", year_model=" + yearModel + ", price="
				+ price + ", licensed=" + licensed + ", date_added=" + dateAdded + ", carLocation=" + carLocation + "]";
	}

}
