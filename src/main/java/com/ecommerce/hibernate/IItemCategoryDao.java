package com.ecommerce.hibernate;

import java.util.List;

import com.ecommerce.model.Category;
import com.ecommerce.model.Item;
import com.ecommerce.model.Tenant;

public interface IItemCategoryDao {
	public void saveOrUpdateCategory(Category cat);
	public void deleteCategory(Category cat);
	public Category getCategoryById(Long id);
	public List<Category> getAllCategory(Tenant tenant);
	
	public Item getItemById(Long itemId);
	public List<Item> getItemByCategory(Category cat);
	public List<Item> getAllItems(Tenant tenant);
	public void saveItem(Item item);
	public void updateItem(Item item);
	public void deleteItem(Item item);
}
