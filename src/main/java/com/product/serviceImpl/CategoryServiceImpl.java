package com.product.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.mapper.CategoryMapper;
import com.product.model.CategoryModel;
import com.product.repository.CategoryRepository;
import com.product.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private CategoryMapper categoryMapper;


	@Override
	public CategoryModel createCategory(CategoryModel categoryModel) {
		categoryRepository.save(categoryMapper.modelToCategoryEntity(categoryModel));
		return categoryModel;
	}

}
