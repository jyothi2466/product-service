package com.product.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "patent", schema = "product_schema")
public class PatentEntity {
	@Id
	@Column(name = "patent_guid")
	private String patentGuid;

	private String name;

	@ManyToOne
	@JoinColumn(name = "product_guid")
	private ProductEntity productEntity;

	public PatentEntity() {

	}

	public PatentEntity(String patentGuid, String name, ProductEntity productEntity) {
		super();
		this.patentGuid = patentGuid;
		this.name = name;
		this.productEntity = productEntity;
	}

	public String getPatentGuid() {
		return patentGuid;
	}

	public void setPatentGuid(String patentGuid) {
		this.patentGuid = patentGuid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ProductEntity getProductEntity() {
		return productEntity;
	}

	public void setProductEntity(ProductEntity productEntity) {
		this.productEntity = productEntity;
	}

}