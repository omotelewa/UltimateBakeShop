package com.ultimatebake.shop.productsapi.service;

import java.util.List;

import com.ultimatebake.shop.productsapi.repository.entity.Products;

public interface ProductsService {
	Products save(Products product);

	boolean delete(int productId);

	List<Products> all();

	Products findById(int productId);

}
