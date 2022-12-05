package com.product.mapper;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.product.entity.CategoryEntity;
import com.product.model.CategoryModel;

@Component
public class CategoryMapper {
	public CategoryEntity modelToCategoryEntity(CategoryModel categoryModel) {
		CategoryEntity categoryEntity = new CategoryEntity();
		BeanUtils.copyProperties(categoryModel, categoryEntity);
		
		return categoryEntity;
	}
}
