package com.ultimatebake.shop.productsapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class TheUltimateBakeShopApplication {

	public static void main(String[] args) {
		SpringApplication.run(TheUltimateBakeShopApplication.class, args);
	}

}
