package com.ultimatebake.shop.productsapi.repository;

import org.springframework.data.repository.CrudRepository;

import com.ultimatebake.shop.productsapi.repository.entity.Products;

public interface ProductsRepository extends CrudRepository<Products, Integer>{

}
