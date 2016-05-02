package com.ecommerce.hibernate;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.ecommerce.model.User;

public class UserDaoImpl extends HibernateDaoSupport implements IUserDao {
	@Override
	public void saveUser(User user) {
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
	public User getUserById(Long tenantId, Long id) {
		try{
			String hql = "SELECT u FROM User u WHERE u.id = ? AND u.tenant = ?";
			Object []args = new Object[] { id, tenantId};
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteUser(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User getUserByUserNameAndPassword(String username, String password) {
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

	
	

}
