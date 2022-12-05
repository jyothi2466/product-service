package com.product.entity;


import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "product", schema = "product_schema")
public class ProductEntity {
	@Id
	@Column(name = "product_guid")
	private String productGuid;
	private String name;
	private String description;

	@OneToOne
	@JoinColumn(name = "category_id")
	private CategoryEntity categoryEntity;

	@Column(name = "product_code")
	private String productCode;

	@Column(name = "unit_price")
	private Double unitPrice;
	
	@Column(name = "unit_weight")
	private Double unitWeight;
	
	@Column(name = "created_by")
	private String createdBy;
	
	@Column(name = "created_date")
	private Date createdDate;
	
	private String uom;

	@OneToOne
	@JoinColumn(name = "product_type_id")
	private ProductTypeEntity productTypeEntity;

	@OneToMany(mappedBy = "productEntity", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<ManufactureEntity> manufactureEntities;

	@OneToMany(mappedBy = "productEntity", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<PatentEntity> patentEntities;

	public ProductEntity() {

	}

	public ProductEntity(String productGuid, String name, String description, CategoryEntity categoryEntity,
			String productCode, Double unitPrice, ProductTypeEntity productTypeEntity,
			List<ManufactureEntity> manufactureEntities, Double unitWeight, String createdBy, Date createdDate,
			String uom, List<PatentEntity> patentEntities) {
		super();
		this.productGuid = productGuid;
		this.name = name;
		this.description = description;
		this.categoryEntity = categoryEntity;
		this.productCode = productCode;
		this.unitPrice = unitPrice;
		this.productTypeEntity = productTypeEntity;
		this.manufactureEntities = manufactureEntities;
		this.unitWeight = unitWeight;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.uom = uom;
		this.patentEntities = patentEntities;
	}

	public String getProductGuid() {
		return productGuid;
	}

	public void setProductGuid(String productGuid) {
		this.productGuid = productGuid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public CategoryEntity getCategoryEntity() {
		return categoryEntity;
	}

	public void setCategoryEntity(CategoryEntity categoryEntity) {
		this.categoryEntity = categoryEntity;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public Double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public ProductTypeEntity getProductTypeEntity() {
		return productTypeEntity;
	}

	public void setProductTypeEntity(ProductTypeEntity productTypeEntity) {
		this.productTypeEntity = productTypeEntity;
	}

	public List<ManufactureEntity> getManufactureEntities() {
		return manufactureEntities;
	}

	public void setManufactureEntities(List<ManufactureEntity> manufactureEntities) {
		this.manufactureEntities = manufactureEntities;
	}

	public Double getUnitWeight() {
		return unitWeight;
	}

	public void setUnitWeight(Double unitWeight) {
		this.unitWeight = unitWeight;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getUom() {
		return uom;
	}

	public void setUom(String uom) {
		this.uom = uom;
	}

	public List<PatentEntity> getPatentEntities() {
		return patentEntities;
	}

	public void setPatentEntities(List<PatentEntity> patentEntities) {
		this.patentEntities = patentEntities;
	}

}
