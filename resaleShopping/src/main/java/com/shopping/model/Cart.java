package com.shopping.model;

import org.json.simple.JSONArray;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Cart {

	@Id
	String sessionId;
	JSONArray cars;

	public Cart(String sessionId, JSONArray cars) {
		super();
		this.sessionId = sessionId;
		this.cars = cars;

	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public JSONArray getCars() {
		return cars;
	}

	public void setCars(JSONArray cars) {
		this.cars = cars;
	}


}
