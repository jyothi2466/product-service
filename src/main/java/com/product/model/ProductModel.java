package com.product.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class ProductModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4346955985944240862L;
	private String productGuid;
	private String name;
	private String description;
	private CategoryModel categoryModel;
	private String productCode;
	private Double unitPrice;
	private ProductTypeModel productTypeModel;
	private List<ManufactureModel> manufactureModels;
	private Double unitWeight;
	private String createdBy;
	private Date createdDate;
	private String uom;
	private List<PatentModel> patentModels;

	public ProductModel() {

	}

	public ProductModel(String productGuid, String name, String description, CategoryModel categoryModel,
			String productCode, Double unitPrice, ProductTypeModel productTypeModel,
			List<ManufactureModel> manufactureModels, Double unitWeight, String createdBy, Date createdDate, String uom,
			List<PatentModel> patentModels) {
		super();
		this.productGuid = productGuid;
		this.name = name;
		this.description = description;
		this.categoryModel = categoryModel;
		this.productCode = productCode;
		this.unitPrice = unitPrice;
		this.productTypeModel = productTypeModel;
		this.manufactureModels = manufactureModels;
		this.unitWeight = unitWeight;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.uom = uom;
		this.patentModels = patentModels;
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

	public CategoryModel getCategoryModel() {
		return categoryModel;
	}

	public void setCategoryModel(CategoryModel categoryModel) {
		this.categoryModel = categoryModel;
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

	public ProductTypeModel getProductTypeModel() {
		return productTypeModel;
	}

	public void setProductTypeModel(ProductTypeModel productTypeModel) {
		this.productTypeModel = productTypeModel;
	}

	public List<ManufactureModel> getManufactureModels() {
		return manufactureModels;
	}

	public void setManufactureModels(List<ManufactureModel> manufactureModels) {
		this.manufactureModels = manufactureModels;
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

	public List<PatentModel> getPatentModels() {
		return patentModels;
	}

	public void setPatentModels(List<PatentModel> patentModels) {
		this.patentModels = patentModels;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	
}