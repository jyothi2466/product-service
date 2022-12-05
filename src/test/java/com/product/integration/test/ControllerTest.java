package com.product.integration.test;

import java.io.IOException;
import java.net.URL;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.product.ProductServiceApplication;
import com.product.entity.CategoryEntity;
import com.product.entity.ProductTypeEntity;
import com.product.mapper.ProductMapper;
import com.product.model.ProductModel;
import com.product.repository.CategoryRepository;
import com.product.repository.ProductTypeRepository;

@SpringBootTest(classes = ProductServiceApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)
@ExtendWith(SpringExtension.class)
@Transactional
public class ControllerTest {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private ProductTypeRepository productTypeRepository;

	@Autowired
	private ProductMapper productMapper;

	private ProductModel productModel;

	@BeforeEach
	@Order(0)
	public void setUp() throws StreamReadException, DatabindException, IOException {
		productModel = new ProductModel();
		productModel.setName("PENCIL");
		productModel.setUnitPrice(10.00);
		productModel.setUnitWeight(50.00);

		productModel = objectMapper.readValue(new URL("file:src/test/java/resources/createproduct.json"),
				ProductModel.class);
	}

	@Test
	@Order(1)
	public void createProductTest() {
		categoryRepository.save(new CategoryEntity(11, "stationary"));
		productTypeRepository.save(new ProductTypeEntity(3, "0.5mm"));

		System.out.println(productModel);

		ResponseEntity<ProductModel> responseEntity = this.restTemplate
				.postForEntity("http://localhost:" + port + "/api/product/v1/create", productModel, ProductModel.class);

	}
}
