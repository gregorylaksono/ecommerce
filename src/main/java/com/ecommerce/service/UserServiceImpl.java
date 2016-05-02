package com.ecommerce.service;

import com.ecommerce.hibernate.IUserDao;
import com.ecommerce.model.Session;
import com.ecommerce.model.User;

public class UserServiceImpl implements IUserService{
	
	protected IUserDao userDao;
	
	@Override
	public int register(User user) {
		userDao.saveUser(user);
		return 0;
	}

	public IUserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public Session getUserByUsernameAndPassword(String username, String password) {
		User user = userDao.getUserByUserNameAndPassword(username, password);
		Session session = null;
		if(user != null){
			session = generateSessionId();
			session.setUser(user);
		}
		return session;
	}


	private Session generateSessionId() {
		Double val = Math.random();
		String sVal = String.valueOf(val);
		int index = sVal.indexOf(".") + 1;
		String sessionId = sVal.substring(index, sVal.length());
		Session session = new Session();
		session.setSessionId(sessionId);
		return session;
	}

	@Override
	public User getUserById(Long tenantId, Long id) {
		return userDao.getUserById(tenantId, id);
	}
	
	

}
