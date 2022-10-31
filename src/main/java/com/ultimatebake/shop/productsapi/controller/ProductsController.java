package com.ultimatebake.shop.productsapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ultimatebake.shop.productsapi.repository.entity.Products;
import com.ultimatebake.shop.productsapi.service.ProductsService;

@RestController
@RequestMapping("/products")
public class ProductsController {
final ProductsService productsService;
	
	public ProductsController(@Autowired ProductsService productsService) {
		this.productsService = productsService;
	}

	@GetMapping
	public Iterable<Products> getProducts() {
		return productsService.all();
	}
}
