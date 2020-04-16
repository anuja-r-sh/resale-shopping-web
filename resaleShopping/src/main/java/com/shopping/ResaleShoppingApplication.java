package com.shopping;

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
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import com.shopping.dao.repository.CarsRepo;
import com.shopping.dao.repository.WareHouseRepo;
import com.shopping.model.Car;
import com.shopping.model.Location;
import com.shopping.model.WareHouse;

/**
 * This class boots the spring application
 * 
 * @author Anuja
 *
 */

@SpringBootApplication
public class ResaleShoppingApplication {

	@Autowired
	private WareHouseRepo wareHouseRepo;

	@Autowired
	private CarsRepo carRepo;

	@Value("${data.seed}")
	private String jsonPath;

	@Autowired
	ResourceLoader resourceLoader;

	public static void main(String[] args) {
		SpringApplication.run(ResaleShoppingApplication.class, args);
	}

	/**
	 * This method loads the initial data in the MongoDB when the application
	 * boots up.
	 *
	 */
	@Bean
	public void loadSeedData() {
		Resource resource = resourceLoader.getResource("classpath:cars.json");
		try (FileReader reader = new FileReader(resource.getFile())) {
			JSONParser jsonParser = new JSONParser();
			// Read JSON file
			Object obj = jsonParser.parse(reader);

			/*
			 * Following code parse through the nested json to store the data
			 * model in the database
			 */
			JSONArray wareHouses = (JSONArray) obj;
			for (Object data : wareHouses) {
				JSONObject wareHouseObject = (JSONObject) data;
				JSONObject locationObject = (JSONObject) wareHouseObject.get("location");

				String longitude = (String) locationObject.get("long");
				String latitude = (String) locationObject.get("lat");

				Location location = new Location(longitude, latitude);

				int wareHouseId = Integer.parseInt((String) wareHouseObject.get("_id"));
				String wareHouseName = (String) wareHouseObject.get("name");
				WareHouse wareHouse = new WareHouse(wareHouseId, location, wareHouseName);

				/* saving in the database */
				wareHouseRepo.save(wareHouse);

				JSONObject cars = (JSONObject) wareHouseObject.get("cars");
				String carLocation = (String) cars.get("location");
				JSONArray carList = (JSONArray) cars.get("vehicles");

				for (Object carObject : carList) {
					JSONObject car = (JSONObject) carObject;
					DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

					long carId = (Long) car.get("_id");
					String maker = (String) car.get("make");
					String model = (String) car.get("model");
					long year = (Long) car.get("year_model");
					Double price = (Double) car.get("price");
					boolean licensed = (Boolean) car.get("licensed");
					Date dateAdded = null;
					try {
						dateAdded = dateFormat.parse((String) car.get("date_added"));
					} catch (java.text.ParseException e) {
						e.printStackTrace();
					}

					/* saving in the database */
					carRepo.save(
							new Car(carId, maker, model, year, price, licensed, dateAdded, carLocation, wareHouse));

				}
			}
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}
	}
}
