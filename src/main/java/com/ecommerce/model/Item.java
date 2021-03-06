package com.ecommerce.model;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

import com.ecommerce.model.Category;


public class Item implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8154159491387798437L;
	private Long id;
	private String name;
	private Double price;
	private String description;
	private int quantity;
	private String imgUrl;
	private Set<Category> category;
	private Tenant tenant;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	public Set<Category> getCategory() {
		return category;
	}
	public void setCategory(Set<Category> category) {
		this.category = category;
	}
	public Tenant getTenant() {
		return tenant;
	}
	public void setTenant(Tenant tenant) {
		this.tenant = tenant;
	}


	
	
}
