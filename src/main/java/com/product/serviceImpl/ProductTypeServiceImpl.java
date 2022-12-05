package com.product.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.mapper.ProductTypeMapper;
import com.product.model.ProductTypeModel;
import com.product.repository.ProductTypeRepository;
import com.product.service.ProductTypeService;

@Service
public class ProductTypeServiceImpl implements ProductTypeService{
	@Autowired
	private ProductTypeRepository productTypeRepository;
	
	@Autowired
	private ProductTypeMapper productTypeMapper;


	@Override
	public ProductTypeModel createProductType(ProductTypeModel productTypeModel) {
		productTypeRepository.save(productTypeMapper.modelToProductTypeEntity(productTypeModel));
		return productTypeModel;
	}
}
