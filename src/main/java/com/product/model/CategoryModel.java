package com.product.model;

public class CategoryModel {
	private int categoryId;
	private String name;
	
	public CategoryModel() {
		
	}

	public CategoryModel(int categoryId, String name) {
		super();
		this.categoryId = categoryId;
		this.name = name;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "CategoryModel [categoryId=" + categoryId + ", name=" + name + "]";
	}
	
}
