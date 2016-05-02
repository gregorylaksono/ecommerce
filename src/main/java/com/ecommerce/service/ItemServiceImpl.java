package com.ecommerce.service;

import com.ecommerce.hibernate.IItemCategoryDao;
import com.ecommerce.model.Category;
import com.ecommerce.model.Item;

public class ItemServiceImpl implements IItemService {
	protected IItemCategoryDao itemCategoryDao;
	
	@Override
	public Category getCategoryById(Long id) {
	
		return itemCategoryDao.getCategoryById(id);
	}

	@Override
	public void insertCategory(Category category) {
		itemCategoryDao.saveOrUpdateCategory(category);
	}

	@Override
	public void deleteCategory(Category category) {
		itemCategoryDao.deleteCategory(category);

	}

	@Override
	public void updateCategory(Category category) {
		itemCategoryDao.saveOrUpdateCategory(category);
	}

	@Override
	public Item getItemById(Long id) {
	
		return null;
	}

	@Override
	public int insertItem(Item item) {
	
		return 0;
	}

	@Override
	public void updateItem(Item item) {
	

	}

	@Override
	public void deleteItem(Item item) {
	

	}

}
