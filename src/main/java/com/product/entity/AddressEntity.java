package com.product.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "address", schema = "product_schema")
public class AddressEntity {
	@Id
	@Column(name = "address_guid")
	private String addressGuid;
	@Column(name = "address_line1")
	private String addressLine1;
	@Column(name = "address_line2")
	private String addressLine2;
	private String city;
	private String state;
	private String country;
	@Column(name = "postal_code")
	private String postalCode;

	@ManyToOne
	@JoinColumn(name = "manufacture_guid")
	private ManufactureEntity manufacture;

	public AddressEntity() {

	}

	public AddressEntity(String addressGuid, String addressLine1, String addressLine2, String city, String state,
			String country, String postalCode, ManufactureEntity manufacture) {
		super();
		this.addressGuid = addressGuid;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.city = city;
		this.state = state;
		this.country = country;
		this.postalCode = postalCode;
		this.manufacture = manufacture;
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

	public ManufactureEntity getManufacture() {
		return manufacture;
	}

	public void setManufacture(ManufactureEntity manufacture) {
		this.manufacture = manufacture;
	}

	
	
}
