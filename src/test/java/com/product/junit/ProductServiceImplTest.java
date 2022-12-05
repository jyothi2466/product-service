package com.product.junit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.product.entity.ProductEntity;
import com.product.mapper.ProductMapper;
import com.product.model.ProductModel;
import com.product.repository.ProductRepository;
import com.product.serviceImpl.ProductServiceImpl;

public class ProductServiceImplTest {

	@InjectMocks
	private ProductServiceImpl productServiceImpl;

	@Mock
	private ProductRepository productRepository;
	@Mock
	private ProductMapper productMapper;

	private ProductModel productModel;

	@BeforeEach
	public void init() {
		MockitoAnnotations.openMocks(this);
		productModel = new ProductModel();
		productModel.setName("PENCIL");
		productModel.setUnitPrice(10.00);
		productModel.setUnitWeight(50.00);
		productModel.setProductCode("123");
	}

	@Test
	public void createProductTest() {

		ProductEntity productEntity = productMapper.modelToProductEntity(productModel);

		when(productMapper.modelToProductEntity(productModel)).thenReturn(productEntity);

		when(productRepository.save(productEntity)).thenReturn(productEntity);

		ProductModel productModel1 = productServiceImpl.createProduct(productModel);
		assertEquals(productModel, productModel1);

	}

}
