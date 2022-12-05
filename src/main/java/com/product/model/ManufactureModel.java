package com.product.model;

import java.io.Serializable;
import java.util.List;

public class ManufactureModel implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 817600562536605923L;
	private String manufactureGuid;
	private String manufactureCode;
	private String companyName;

	private List<AddressModel> addressModels;
	private List<ContactModel> contactModels;

	public ManufactureModel() {

	}

	public ManufactureModel(String manufactureGuid, String manufactureCode, String companyName,
			List<AddressModel> addressModels, List<ContactModel> contactModels) {
		super();
		this.manufactureGuid = manufactureGuid;
		this.manufactureCode = manufactureCode;
		this.companyName = companyName;
		this.addressModels = addressModels;
		this.contactModels = contactModels;
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

	public List<AddressModel> getAddressModels() {
		return addressModels;
	}

	public void setAddressModels(List<AddressModel> addressModels) {
		this.addressModels = addressModels;
	}

	public List<ContactModel> getContactModels() {
		return contactModels;
	}

	public void setContactModels(List<ContactModel> contactModels) {
		this.contactModels = contactModels;
	}

	
}