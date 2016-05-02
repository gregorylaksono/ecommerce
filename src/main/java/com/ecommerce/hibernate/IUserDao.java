package com.ecommerce.hibernate;

import com.ecommerce.model.User;

public interface IUserDao {
	
	public void saveUser(User user);
	public User getUserById(Long tenantId, Long id);
	public User getUserByUserNameAndPassword(String username, String password);
	public User getUserByMail(String email);
	public void deleteUser(User user);
}
