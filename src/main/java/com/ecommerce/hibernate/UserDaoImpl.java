package com.ecommerce.hibernate;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.ecommerce.model.Tenant;
import com.ecommerce.model.User;

public class UserDaoImpl extends HibernateDaoSupport implements IUserDao {
	@Override
	public void saveUser( User user) {
		Session session = getHibernateTemplate().getSessionFactory().openSession();
		Transaction trx = session.beginTransaction();
		try{
			getHibernateTemplate().save(user);
			trx.commit();			
		}catch(Exception e){
			trx.rollback();
			e.printStackTrace();
		}
		
	}

	@Override
	public User getUserById(Long id) {
		try{
			String hql = "SELECT u FROM User u WHERE u.id = ?";
			Object []args = new Object[] { id};
			List result = getHibernateTemplate().find(hql, args);
			if(result != null && result.size() > 0){
				return (User) result.get(0);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public User getUserByMail(String email) {
		try{
			String hql = "SELECT u FROM User u WHERE u.email = ?";
			Object []args = new Object[] { email};
			List result = getHibernateTemplate().find(hql, args);
			if(result != null && result.size() > 0){
				return (User) result.get(0);
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
	public void deleteUser(User user) {
		User u = getUserById(user.getId());
		Session session = getHibernateTemplate().getSessionFactory().openSession();
		Transaction trx = session.beginTransaction();
		try{
			getHibernateTemplate().delete(u);
			trx.commit();			
		}catch(Exception e){
			trx.rollback();
			e.printStackTrace();
		}
	}

	@Override
	public User getUserByUserNameAndPassword( String username, String password) {
		try{
			String hql = "SELECT u FROM User u WHERE u.username = ? AND u.password = ?";
			Object []args = new Object[] { username, password };
			List result = getHibernateTemplate().find(hql, args);
			if(result != null && result.size() > 0){
				return (User) result.get(0);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return null;
	
	}

	@Override
	public Tenant getTenantById(Long tenantId) {
		try{
			String hql = "SELECT u FROM User u WHERE u.tenantId = ?";
			Object []args = new Object[] {tenantId};
			List result = getHibernateTemplate().find(hql, args);
			if(result != null && result.size() > 0){
				return (Tenant) result.get(0);
			}
			else{
				return null;
			}
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}

}
