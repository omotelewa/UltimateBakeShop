package com.ultimatebake.shop.productsapi;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.ultimatebake.shop.productsapi.controller.ProductsController;
import com.ultimatebake.shop.productsapi.repository.entity.Products;
import com.ultimatebake.shop.productsapi.service.ProductsService;

@ExtendWith(SpringExtension.class)
//@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@WebMvcTest(value = ProductsController.class)
public class ProductsControllerTest {
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private ProductsService productsService;

	@Test
	public void testGetProducts() throws Exception {

		List<Products> mockProducts = new ArrayList<Products>();
		Products products = new Products();
		products.setId(1);
		products.setName("Choco Cookies");
		products.setDescription("Filled with choco");
		products.setImageUrl("choco.jpg");
		mockProducts.add(products);
		Mockito.when(productsService.all()).thenReturn(mockProducts);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/products/all").accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		System.out.println(result.getResponse());
		String expected = "[{\"id\":1,\"name\":\"Choco Cookies\",\"description\":\"Filled with choco\",\"imageUrl\":\"choco.jpg\"}]";

		JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
	}

	@Test
	public void testCreateProduct() throws Exception {
		Products products = new Products();
		products.setId(1);
		products.setName("Choco Cookies");
		products.setDescription("Filled with choco");
		products.setImageUrl("choco.jpg");

		String requestBodyJson = "{\"name\":  \"Choco Cookies\",\"description\": \"Filled with choco\", \"imageUrl\" : \"choco.jpg\"\r\n"
				+ "}";

		Mockito.when(productsService.save(Mockito.any(Products.class))).thenReturn(products);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/products").accept(MediaType.APPLICATION_JSON)
				.content(requestBodyJson).contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		MockHttpServletResponse response = result.getResponse();

		assertEquals(200, response.getStatus());

	}
	
	@Test
	public void testGetFindProductById() throws Exception {

		Products products = new Products();
		products.setId(1);
		products.setName("Choco Cookies");
		products.setDescription("Filled with choco");
		products.setImageUrl("choco.jpg");
		Mockito.when(productsService.findById(1)).thenReturn(products);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/products/1").accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		System.out.println(result.getResponse());
		String expected = "{\"id\":1,\"name\":\"Choco Cookies\",\"description\":\"Filled with choco\",\"imageUrl\":\"choco.jpg\"}";

		JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
	}
	
	@Test
	public void testUpdateProducts() throws Exception {
		Products products = new Products();
		products.setId(1);
		products.setName("Choco Cookies");
		products.setDescription("Filled with choco");
		products.setImageUrl("choco.jpg");

		String requestBodyJson = "{\"name\":  \"Choco Cookies\",\"description\": \"Filled with choco\", \"imageUrl\" : \"choco.jpg\"\r\n"
				+ "}";
		Mockito.when(productsService.findById(1)).thenReturn(products);

		Mockito.when(productsService.save(Mockito.any(Products.class))).thenReturn(products);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.put("/products/1").accept(MediaType.APPLICATION_JSON)
				.content(requestBodyJson).contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		MockHttpServletResponse response = result.getResponse();

		assertEquals(200, response.getStatus());

	}

}
