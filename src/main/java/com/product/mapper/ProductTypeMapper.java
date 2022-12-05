package com.product.mapper;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.product.entity.ProductTypeEntity;
import com.product.model.ProductTypeModel;

@Component
public class ProductTypeMapper {
	public ProductTypeEntity modelToProductTypeEntity(ProductTypeModel productTypeModel) {
		ProductTypeEntity productTypeEntity = new ProductTypeEntity();
		BeanUtils.copyProperties(productTypeModel, productTypeEntity);
		return productTypeEntity;
	}
}
