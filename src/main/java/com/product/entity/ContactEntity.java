package com.product.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="contact", schema="product_schema")
public class ContactEntity {
	@Id
	@Column(name="contact_guid")
	private String contactGuid;
	
	
	private String value;
	
	@ManyToOne
	@JoinColumn(name="manufacture_guid")
	private ManufactureEntity manufacture;
	
	public ContactEntity() {
		
	}

	public ContactEntity(String contactGuid, String value, ManufactureEntity manufacture) {
		super();
		this.contactGuid = contactGuid;
		this.value = value;
		this.manufacture = manufacture;
	}

	public String getContactGuid() {
		return contactGuid;
	}

	public void setContactGuid(String contactGuid) {
		this.contactGuid = contactGuid;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public ManufactureEntity getManufacture() {
		return manufacture;
	}

	public void setManufacture(ManufactureEntity manufacture) {
		this.manufacture = manufacture;
	}

	}
	
	
	

