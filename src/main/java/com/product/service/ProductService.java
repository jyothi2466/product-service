package com.product.service;

import java.util.List;

import com.product.model.ProductModel;

public interface ProductService {
	public ProductModel createProduct(ProductModel productModel);
	public List<ProductModel> findByName(String name);
	public ProductModel findByProductCode(String productCode);
	public ProductModel updateProduct(ProductModel productModel);
	public void deleteProductByName(String name);
	public void deleteById(String productGuid);
	
}
