package com.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.model.CategoryModel;
import com.product.serviceImpl.CategoryServiceImpl;

@RestController
@RequestMapping("/api/category/v2")
public class CategoryController {
	@Autowired
	private CategoryServiceImpl categoryServiceImpl;

	@PostMapping("/create")
	public CategoryModel createCategory(@RequestBody CategoryModel categoryModel) {

		categoryServiceImpl.createCategory(categoryModel);
		return categoryModel;
	}
}
