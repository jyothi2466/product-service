package com.product.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="contact_type", schema="product_schema")
public class ContactTypeEntity {
	@Id
	@Column(name="contact_type_id")
	private int contactTypeId;
	private String name;
	
	public ContactTypeEntity() {
		
	}

	public ContactTypeEntity(int contactTypeId, String name) {
		super();
		this.contactTypeId = contactTypeId;
		this.name = name;
	}

	public int getContactTypeId() {
		return contactTypeId;
	}

	public void setContactTypeId(int contactTypeId) {
		this.contactTypeId = contactTypeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
