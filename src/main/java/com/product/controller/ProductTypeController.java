package com.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.model.ProductTypeModel;
import com.product.serviceImpl.ProductTypeServiceImpl;

@RestController
@RequestMapping("/api/productType/v3")
public class ProductTypeController {
	@Autowired
	private ProductTypeServiceImpl productTypeServiceImpl;

	@PostMapping("/create")
	public ProductTypeModel createProductType(@RequestBody ProductTypeModel ProductTypeModel) {

		productTypeServiceImpl.createProductType(ProductTypeModel);
		return ProductTypeModel;
	}
}
