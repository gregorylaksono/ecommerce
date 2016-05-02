package com.ecommerce.service;

import com.ecommerce.model.Category;
import com.ecommerce.model.Item;

public interface ItemService {
	public Category getCategoryById(Long id);
	public int insertCategory(Category category);
	public void deleteCategory(Category category);
	public void updateCategory(Category category);
	
	public Item getItemById(Long id);
	public int insertItem(Item item);
	public void updateItem(Item item);
	public void deleteItem(Item item);
}
