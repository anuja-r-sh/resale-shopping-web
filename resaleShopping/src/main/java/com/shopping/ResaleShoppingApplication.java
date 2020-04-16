package com.shopping;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * This class boots the spring application
 * 
 * @author Anuja
 *
 */

@SpringBootApplication
public class ResaleShoppingApplication {


	public static void main(String[] args) {
		SpringApplication.run(ResaleShoppingApplication.class, args);
	}

	/**
	 * This method loads the initial data in the MongoDB when the application
	 * boots up.
	 *
	 */
	
}
