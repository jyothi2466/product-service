package com.product.junit;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.product.controller.ProductController;
import com.product.model.ProductModel;
import com.product.serviceImpl.ProductServiceImpl;

@WebMvcTest(ProductController.class)
public class ProductControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private ProductServiceImpl productServiceImpl;

	@Autowired
	private ObjectMapper objectMapper;

	private ProductModel productModel;
	
	public void setUp() {
		productModel = new ProductModel();
		productModel.setName("PENCIL");
		productModel.setUnitPrice(10.00);
		productModel.setUnitWeight(50.00);

	}

	@Test
	void createProductTest() throws Exception {
		productModel = new ProductModel();
		productModel.setName("PENCIL");
		productModel.setUnitPrice(10.00);
		productModel.setUnitWeight(50.00);

		when(productServiceImpl.createProduct(productModel)).thenReturn(productModel);

		mockMvc.perform(post("/api/product/v1/create")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(productModel)))
		        .andExpect(status().isOk()).andDo(print());
	}
	@Test
	void findByProductCodeTest() throws Exception {

	//	List<ProductModel> productModels = new ArrayList<>();
		//productModels.add(productModel);
		

		/*
		 * mockMvc.perform(get("/api/product/v1/findByName/PENCIL"))
		 * .andExpect(status().isOk())
		 * .andExpect(jsonPath("$.size()").value(productModels.size())) .andDo(print());
		 */
		
		
		/*
		 * String expected=objectMapper.writeValueAsString(productModel); RequestBuilder
		 * requestBuilder = MockMvcRequestBuilders
		 * .get("/api/product/v1/findByProductCode/{productCode}","PENCIL")
		 * .accept(MediaType.APPLICATION_JSON);
		 * 
		 * MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		 * System.out.println("Response-->"+result.getResponse().getContentAsString());
		 * System.out.println("expected-->"+expected);
		 * 
		 * JSONAssert.assertEquals(expected, result.getResponse() .getContentAsString(),
		 * false);
		 */
		productModel = new ProductModel();
		productModel.setName("PENCIL");
		productModel.setUnitPrice(10.00);
		productModel.setUnitWeight(50.00);
		productModel.setProductCode("123");
		
		when(productServiceImpl.findByProductCode("123")).thenReturn(productModel);
		
		mockMvc.perform(MockMvcRequestBuilders
	            .get("/api/product/v1/findByProductCode/123")
	            .contentType(MediaType.APPLICATION_JSON))
	            .andExpect(status().isOk());
	         //   .andExpect(jsonPath("$", notNullValue()))
	         // .andExpect(jsonPath("$.name", is("PENCIL")));
	}

}
