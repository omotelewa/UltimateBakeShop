package com.ultimatebake.shop.productsapi.repository.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.ultimatebake.shop.productsapi.dto.ProductsDto;
@Entity
public class Products {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String name;
	private String description;
	private String imageUrl;
	
	
	
	public Products() {
		super();
	}
	public Products(ProductsDto productsDto) {
		this.name = productsDto.getName();
		this.description = productsDto.getDescription();
		this.imageUrl = productsDto.getImageUrl();
	}
	public Integer getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getDescription() {
		return description;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	

}
