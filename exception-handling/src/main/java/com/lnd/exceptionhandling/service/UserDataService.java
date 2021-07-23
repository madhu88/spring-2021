package com.lnd.exceptionhandling.service;

import java.util.List;

import com.lnd.exceptionhandling.model.User;


public interface UserDataService {
	
	public User addUser(final User user);
	
	public User getUser(final Long id);
	
	public List<User> getAllUsers();

}
