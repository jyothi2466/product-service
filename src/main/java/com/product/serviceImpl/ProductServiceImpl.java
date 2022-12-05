package com.product.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.product.mapper.ProductMapper;
import com.product.model.ProductModel;
import com.product.repository.ProductRepository;
import com.product.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private ProductMapper productMapper;

	@Override
	public ProductModel createProduct(ProductModel productModel) {
		productRepository.save(productMapper.modelToProductEntity(productModel));
		return productModel;
	}

	@Override
	public List<ProductModel> findByName(String name) {
		return productMapper.entitiesToProductModel(productRepository.findByName(name));
	}

	@Override
	public ProductModel findByProductCode(String productCode) {
		return productMapper.entityToProductModel(productRepository.findByProductCode(productCode));
	}

	@Override
	public ProductModel updateProduct(ProductModel productModel) {
		productRepository.save(productMapper.modelToProductEntity(productModel));
		return productModel;
	}

	@Override
	@Transactional
	public void deleteProductByName(String name) {
		productRepository.deleteByName(name);
	}

	@Override
	public void deleteById(String productGuid) {
		productRepository.deleteById(productGuid);
	}

}
