package com.shopping.services;

/**
 * Following class updates the middleware class for data processing 
 * between controller and dao layer for Cart operations.
 */
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping.dao.repository.CartRepo;
import com.shopping.model.Cart;

@Service
public class CartService {

	@Autowired
	CartRepo cartRepo;

	public String checkout(String json) {
		/*
		 * Converting the string request body to Cart object to save to DB.
		 */
		try {
			JSONParser jsonParser = new JSONParser();
			Object obj = jsonParser.parse(json);
			JSONObject cartJSON = (JSONObject) obj;
			String sessionId = (String) cartJSON.get("sessionId");

			JSONArray cartArray = (JSONArray) cartJSON.get("cart");
			Cart cart = new Cart(sessionId, cartArray);
			cartRepo.save(cart);
			return "success";
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

}
