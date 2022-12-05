package com.product.model;

public class ProductTypeModel {
	
	private int productTypeId;
	
	private String name;

	public ProductTypeModel() {

	}

	public ProductTypeModel(int productTypeId, String name) {
		super();
		this.productTypeId = productTypeId;
		this.name = name;
	}

	public int getProductTypeId() {
		return productTypeId;
	}

	public void setProductTypeId(int productTypeId) {
		this.productTypeId = productTypeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "ProductTypeModel [productTypeId=" + productTypeId + ", name=" + name + "]";
	}

}
