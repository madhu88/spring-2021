package com.lnd.custom.error.response.service;

import java.util.List;

import com.lnd.custom.error.response.model.User;


public interface UserDataService {
	
	public User addUser(final User user);
	
	public User getUser(final Long id);
	
	public List<User> getAllUsers();

}
