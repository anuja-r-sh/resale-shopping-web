package com.shopping.services;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import com.shopping.dao.repository.CarsRepo;
import com.shopping.dao.repository.WareHouseRepo;
import com.shopping.model.Car;
import com.shopping.model.Location;
import com.shopping.model.WareHouse;

@Service
public class Utility {

	@Autowired
	private WareHouseRepo wareHouseRepo;

	@Autowired
	private CarsRepo carRepo;

	private Date getParsedDate(JSONObject carJSON) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		try {
			return dateFormat.parse((String) carJSON.get("date_added"));
		} catch (java.text.ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	
	public void loadWareHouseData(String seedData) {

		JSONParser jsonParser = new JSONParser();
		// Read JSON file
		Object obj;
		try {
			obj = jsonParser.parse(seedData);

			/*
			 * Following code parse through the nested json to store the data
			 * model in the database
			 */
			// TODO use the ObjectMapper for object creation
			JSONArray wareHouses = (JSONArray) obj;
			for (Object data : wareHouses) {
				JSONObject wareHouseObject = (JSONObject) data;
				JSONObject locationObject = (JSONObject) wareHouseObject.get("location");

				String longitude = (String) locationObject.get("long");
				String latitude = (String) locationObject.get("lat");

				Location location = new Location(longitude, latitude);

				int wareHouseId = Integer.parseInt((String) wareHouseObject.get("_id"));
				String wareHouseName = (String) wareHouseObject.get("name");

				JSONObject cars = (JSONObject) wareHouseObject.get("cars");
				String carLocation = (String) cars.get("location");
				JSONArray carList = (JSONArray) cars.get("vehicles");
				List<Car> list = new ArrayList<>();
				for (Object carObject : carList) {
					JSONObject carJSON = (JSONObject) carObject;

					long carId = (Long) carJSON.get("_id");
					String maker = (String) carJSON.get("make");
					String model = (String) carJSON.get("model");
					long year = (Long) carJSON.get("year_model");
					Double price = (Double) carJSON.get("price");
					boolean licensed = (Boolean) carJSON.get("licensed");
					Date dateAdded = getParsedDate(carJSON);

					Car car = new Car(carId, maker, model, year, price, licensed, dateAdded, carLocation);
					/* saving in the database */
					carRepo.save(car);
					list.add(car);

				}
				WareHouse wareHouse = new WareHouse(wareHouseId, location, wareHouseName, list);

				/* saving in the database */
				wareHouseRepo.save(wareHouse);
			}
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
	}

	
}
