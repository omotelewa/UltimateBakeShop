package com.ultimatebake.shop.productsapi;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.ultimatebake.shop.productsapi.repository.ProductsRepository;
import com.ultimatebake.shop.productsapi.repository.entity.Products;
import com.ultimatebake.shop.productsapi.service.ProductsService;
import com.ultimatebake.shop.productsapi.service.ProductsServiceMySQL;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;


@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ProductsServiceMySQLTest {
	
	@Mock	
	private ProductsRepository productsRepository;
	private ProductsService  productsService;
	@BeforeAll 
	public void setup() {
		productsService = new ProductsServiceMySQL(productsRepository); 
	}
	@Test
	public void saveCallsProductsRepositorySave() {
		Products productsMock = mock( Products.class );
        productsService.save( productsMock );
        verify( productsRepository ).save( productsMock );


	}
}
