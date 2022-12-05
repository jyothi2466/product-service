package com.product.model;

public class ContactTypeModel {
	private int contactTypeId;
	private String name;
	
	public ContactTypeModel() {
		
	}

	public ContactTypeModel(int contactTypeId, String name) {
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
