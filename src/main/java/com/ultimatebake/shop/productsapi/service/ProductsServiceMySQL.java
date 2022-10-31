package com.ultimatebake.shop.productsapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ultimatebake.shop.productsapi.repository.ProductsRepository;
import com.ultimatebake.shop.productsapi.repository.entity.Products;
@Service
public class ProductsServiceMySQL implements ProductsService {

	private final ProductsRepository productsRepository;
	
	public ProductsServiceMySQL(@Autowired ProductsRepository productsRepository) {
		super();
		this.productsRepository = productsRepository;
	}

	@Override
	public Products save(Products product) {
		
		return productsRepository.save(product);
		
	}

	@Override
	public boolean delete(int productId) {
		
		productsRepository.deleteById(productId);
		return true;
	}

	@Override
	public List<Products> all() {
		return (List<Products>) productsRepository.findAll();

	}

	@Override
	public Products findById(int productId) {
			return productsRepository.findById(productId).get();
	}

}
