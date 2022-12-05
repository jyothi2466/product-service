package com.product.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.model.ProductModel;
import com.product.serviceImpl.ProductServiceImpl;

@RestController
@RequestMapping("/api/product/v1")
public class ProductController {

	@Autowired
	private ProductServiceImpl productServiceImpl;
	
	@PostMapping("/create")
	public ProductModel createProduct(@RequestBody ProductModel productModel) {
		productModel.setProductGuid(UUID.randomUUID().toString());

		productServiceImpl.createProduct(productModel);
		return productModel;
	}
	
	@GetMapping("/findByName/{name}")
	public List<ProductModel> findByName(@PathVariable String name) {

		return productServiceImpl.findByName(name);
	}
	
	@GetMapping("/findByProductCode/{productCode}")
	public ProductModel findByProductCode(@PathVariable String productCode) {
		return productServiceImpl.findByProductCode(productCode);
		
	}

	@PutMapping("/update")
	public ProductModel updateProduct(@RequestBody ProductModel productModel) {
		productServiceImpl.updateProduct(productModel);
		return productModel;
	}

	@DeleteMapping("/deleteByname/{name}")
	public void deleteProductByName(@PathVariable String name) {
		productServiceImpl.deleteProductByName(name);
	}

	
	
	@DeleteMapping("/deleteById/{productGuid}")
	public void deleteById(@PathVariable String productGuid) {
		productServiceImpl.deleteById(productGuid);
	}
}
