package com.ecommerce.model;

import java.io.Serializable;

public class Category implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -30736372511846723L;


	private String name;
	private Long id;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
}
