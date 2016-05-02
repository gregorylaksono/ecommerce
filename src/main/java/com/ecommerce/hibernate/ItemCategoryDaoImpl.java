package com.ecommerce.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.ecommerce.model.Category;
import com.ecommerce.model.Item;
import com.ecommerce.model.Tenant;
import com.ecommerce.model.User;

public class ItemCategoryDaoImpl extends HibernateDaoSupport implements IItemCategoryDao {

	@Override
	public void saveOrUpdateCategory(Category cat) {
		Session session = getHibernateTemplate().getSessionFactory().openSession();
		Transaction trx = session.beginTransaction();
		try{
			getHibernateTemplate().saveOrUpdate(cat);
			trx.commit();			
		}catch(Exception e){
			trx.rollback();
			e.printStackTrace();
		}
	}

	@Override
	public void deleteCategory(Category cat) {
		Session session = getHibernateTemplate().getSessionFactory().openSession();
		Transaction trx = session.beginTransaction();
		try{
			getHibernateTemplate().delete(cat);
			trx.commit();			
		}catch(Exception e){
			trx.rollback();
			e.printStackTrace();
		}

	}

	@Override
	public Category getCategoryById(Long id) {
		try{
			String hql = "SELECT c FROM Category c WHERE c.id = ?";
			Object []args = new Object[] {id};
			List result = getHibernateTemplate().find(hql, args);
			if(result != null && result.size() > 0){
				return (Category) result.get(0);
			}
			else{
				return null;
			}
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Category> getAllCategory(Tenant tenant) {
		try{
			String hql = "SELECT c FROM Category c WHERE c.tenant = ?";
			Object []args = new Object[] {tenant};
			List result = getHibernateTemplate().find(hql, args);
			if(result != null && result.size() > 0){
				return result;
			}
			else{
				return null;
			}
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Item getItemById(Long itemId) {

		return null;
	}

	@Override
	public List<Item> getItemByCategory(Category cat) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Item> getAllItems(Tenant tenant) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveItem(Item item) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateItem(Item item) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteItem(Item item) {
		// TODO Auto-generated method stub
		
	}

}
