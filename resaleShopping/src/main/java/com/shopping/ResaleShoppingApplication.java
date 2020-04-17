package com.shopping;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ResourceUtils;

import com.shopping.services.Utility;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * This class boots the spring application
 * 
 * @author Anuja
 *
 */

@SpringBootApplication
@Configuration
@EnableSwagger2
public class ResaleShoppingApplication {

	@Autowired
	private Utility utility;

	public static void main(String[] args) {
		SpringApplication.run(ResaleShoppingApplication.class, args);
	}

	/**
	 * This method loads the initial data in the MongoDB when the application
	 * boots up.
	 *
	 */

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any()).build();
	}

	@Bean
	public void loadSeedData() throws FileNotFoundException {
		File file = null;
		try {
			file = ResourceUtils.getFile("classpath:cars.json");
			String seedData = new String(Files.readAllBytes(file.toPath()));
			utility.loadWareHouseData(seedData);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
