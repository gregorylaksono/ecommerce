package com.ecommerce.model;

import java.io.Serializable;

public class Tenant implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5896767752150704452L;
	private Long tenantId;
	private String name;
	private User admin;
	private String status;
	
	public Long getTenantId() {
		return tenantId;
	}
	public void setTenantId(Long tenantId) {
		this.tenantId = tenantId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public User getAdmin() {
		return admin;
	}
	public void setAdmin(User admin) {
		this.admin = admin;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
