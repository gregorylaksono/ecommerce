package com.ecommerce.service;

import com.ecommerce.model.Session;
import com.ecommerce.model.User;

public interface IUserService {
	public Session getUserByUsernameAndPassword(String username, String password);
	public int register(User user);
	public User getUserById(Long tenantId , Long id);
}
