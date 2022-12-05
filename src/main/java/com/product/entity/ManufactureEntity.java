package com.product.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="manufacture", schema="product_schema")
public class ManufactureEntity {
	@Id
	@Column(name="manufacture_guid")
	private String manufactureGuid;
	@Column(name="manufacture_code")
	private String manufactureCode;
	@Column(name="company_name")
	private String companyName;
	
	@ManyToOne
	@JoinColumn(name= "product_guid")
	private ProductEntity productEntity;
	
	@OneToMany(mappedBy="manufacture", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<AddressEntity> addressEntities;
	
	@OneToMany(mappedBy="manufacture", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<ContactEntity> contactEntities;
	
	public ManufactureEntity() {
		
	}

	public ManufactureEntity(String manufactureGuid, String manufactureCode, String companyName,
			ProductEntity productEntity, List<AddressEntity> addressEntities, List<ContactEntity> contactEntities) {
		super();
		this.manufactureGuid = manufactureGuid;
		this.manufactureCode = manufactureCode;
		this.companyName = companyName;
		this.productEntity = productEntity;
		this.addressEntities = addressEntities;
		this.contactEntities = contactEntities;
	}

	public String getManufactureGuid() {
		return manufactureGuid;
	}

	public void setManufactureGuid(String manufactureGuid) {
		this.manufactureGuid = manufactureGuid;
	}

	public String getManufactureCode() {
		return manufactureCode;
	}

	public void setManufactureCode(String manufactureCode) {
		this.manufactureCode = manufactureCode;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public ProductEntity getProductEntity() {
		return productEntity;
	}

	public void setProductEntity(ProductEntity productEntity) {
		this.productEntity = productEntity;
	}

	public List<AddressEntity> getAddressEntities() {
		return addressEntities;
	}

	public void setAddressEntities(List<AddressEntity> addressEntities) {
		this.addressEntities = addressEntities;
	}

	public List<ContactEntity> getContactEntities() {
		return contactEntities;
	}

	public void setContactEntities(List<ContactEntity> contactEntities) {
		this.contactEntities = contactEntities;
	}

	
}
