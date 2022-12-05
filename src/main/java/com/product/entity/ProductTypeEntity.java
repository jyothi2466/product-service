package com.product.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="product_type", schema="product_schema")
public class ProductTypeEntity {
	@Id
	@Column(name="product_type_id")
	private int productTypeId;
	private String name;
	
	public ProductTypeEntity() {
		
	}

	public ProductTypeEntity(int productTypeId, String name) {
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
	
}