package com.ecommerce.service;

import com.ecommerce.model.Category;
import com.ecommerce.model.Item;

public interface IItemService {
	public Category getCategoryById(Long id);
	public void insertCategory(Category category);
	public void deleteCategory(Category category);
	public void updateCategory(Category category);
	
	public Item getItemById(Long id);
	public void insertItem(Item item);
	public void updateItem(Item item);
	public void deleteItem(Item item);
}
