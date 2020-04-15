package com.shopping;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.shopping.dao.mongo.model.Car;
import com.shopping.dao.mongo.model.Location;
import com.shopping.dao.mongo.model.WareHouse;
import com.shopping.dao.mongo.repository.CarsRepo;
import com.shopping.dao.mongo.repository.WareHouseRepo;

@SpringBootApplication
public class ResaleShoppingApplication {
	@Autowired
	WareHouseRepo wareHouseRepo;

	@Autowired
	CarsRepo carRepo;

	public static void main(String[] args) {
		SpringApplication.run(ResaleShoppingApplication.class, args);
	}

	@Bean
	public String loadSeedData() {

		try (FileReader reader = new FileReader(System.getProperty("user.dir") + "/src/main/resources/cars.json")) {
			JSONParser jsonParser = new JSONParser();
			// Read JSON file
			Object obj = jsonParser.parse(reader);

			JSONArray wareHouses = (JSONArray) obj;
			for (Object data : wareHouses) {
				JSONObject wareHouseObject = (JSONObject) data;
				JSONObject locationObject = (JSONObject) wareHouseObject.get("location");

				Location location = new Location((String) locationObject.get("long"),
						(String) locationObject.get("lat"));
				WareHouse wareHouse = new WareHouse(Integer.parseInt((String) wareHouseObject.get("_id")), location,
						(String) wareHouseObject.get("name"));
				wareHouseRepo.save(wareHouse);

				JSONObject cars = (JSONObject) wareHouseObject.get("cars");
				String carLocation = (String) cars.get("location");
				JSONArray carList = (JSONArray) cars.get("vehicles");
				for (Object carObject : carList) {
					JSONObject car = (JSONObject) carObject;
					DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
					Date dateAdded;
					try {
						dateAdded = dateFormat.parse((String) car.get("date_added"));
						carRepo.save(new Car((Long) car.get("_id"), (String) car.get("make"), (String) car.get("model"),
								(Long) car.get("year_model"), (Double) car.get("price"), (Boolean) car.get("licensed"),
								dateAdded, carLocation, wareHouse));
					} catch (java.text.ParseException e) {
						e.printStackTrace();
					}

				}

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
}
