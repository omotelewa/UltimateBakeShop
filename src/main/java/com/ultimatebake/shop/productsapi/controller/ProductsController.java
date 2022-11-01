package com.ultimatebake.shop.productsapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ultimatebake.shop.productsapi.dto.ProductsDto;
import com.ultimatebake.shop.productsapi.repository.entity.Products;
import com.ultimatebake.shop.productsapi.service.ProductsService;

@RestController
@RequestMapping("/products")
public class ProductsController {
	final ProductsService productsService;

	public ProductsController(@Autowired ProductsService productsService) {
		this.productsService = productsService;
	}

	@GetMapping("/all")
	public Iterable<Products> getProducts() {
		return productsService.all();
	}

	@CrossOrigin
	@PostMapping
	public Products save(@RequestBody ProductsDto productsDto) {
		return productsService.save(new Products(productsDto));
	}

	@GetMapping("/{id}")
	public Products findProductsById(@PathVariable Integer id) {
		return productsService.findById(id);
	}

	@PutMapping("/{id}")
	public Products update(@RequestBody ProductsDto productsDto, @PathVariable Integer id) {
		Products products = productsService.findById(id);
		products.setName(productsDto.getName());
		products.setDescription(productsDto.getDescription());
		products.setImageUrl(productsDto.getImageUrl());
		return productsService.save(products);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		productsService.delete(id);
	}

}
