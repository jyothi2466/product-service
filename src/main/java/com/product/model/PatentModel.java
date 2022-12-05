package com.product.model;

import java.io.Serializable;

public class PatentModel implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3451611218248101177L;
	private String patentGuid;
	private String name;

	public PatentModel() {

	}

	public PatentModel(String patentGuid, String name) {
		super();
		this.patentGuid = patentGuid;
		this.name = name;
	}

	public String getPatentGuid() {
		return patentGuid;
	}

	public void setPatentGuid(String patentGuid) {
		this.patentGuid = patentGuid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
