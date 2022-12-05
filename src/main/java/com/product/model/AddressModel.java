package com.product.model;

import java.io.Serializable;

public class AddressModel implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7136265068777435102L;
	
	private String addressGuid;
	private String addressLine1;
	private String addressLine2;
	private String city;
	private String state;
	private String country;
	private String postalCode;

	public AddressModel() {

	}

	public AddressModel(String addressGuid, String addressLine1, String addressLine2, String city, String state,
			String country, String postalCode) {
		super();
		this.addressGuid = addressGuid;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.city = city;
		this.state = state;
		this.country = country;
		this.postalCode = postalCode;
	}

	public String getAddressGuid() {
		return addressGuid;
	}

	public void setAddressGuid(String addressGuid) {
		this.addressGuid = addressGuid;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	

}
