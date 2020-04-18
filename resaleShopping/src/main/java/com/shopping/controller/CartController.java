package com.shopping.controller;

/**
 * Following class it rest entry point for cart operations.
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.services.CartService;

@RestController
public class CartController {

	@Autowired
	private CartService cartService;


	@PostMapping(value = "/checkout")
	@CrossOrigin(origins = "*")
	public String checkout(@RequestBody String json) {

		return cartService.checkout(json);

	}
}
