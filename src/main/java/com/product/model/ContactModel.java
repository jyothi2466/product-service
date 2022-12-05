package com.product.model;

import java.io.Serializable;

public class ContactModel implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2983304155142949367L;
	private String contactGuid;
	private String value;

	public ContactModel() {

	}

	public ContactModel(String contactGuid, String value) {
		super();
		this.contactGuid = contactGuid;
		this.value = value;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	

}
