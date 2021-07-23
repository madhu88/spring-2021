package com.lnd.exceptionhandling.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.lnd.exceptionhandling.model.User;
import com.lnd.exceptionhandling.service.UserDataService;

@Service
public class UserDataServiceImpl implements UserDataService {
	
	private static Map<Long, User> userData = new HashMap<Long, User>();

	@Override
	public User addUser(final User user) {
		User addedUser = null;
		if (null != user) {
			System.out.println("trying to add user with id = " + user.getId());
			if (null == userData.get(user.getId())) {
				userData.put(user.getId(), user);
				System.out.println("added user with id = " + user.getId());
				addedUser = userData.get(user.getId());
			} else {
				System.out.println("User with [ " + user.getId() 
				+ " ] already present");
			}
		} else {
			System.out.println("ERROR user object is " + user);
		}
		return addedUser;
	}

	@Override
	public User getUser(final Long id) {
		User user = null;
		System.out.println("id is " + id);
		if (null != id) {
			if (null != userData.get(id)) {
				user = userData.get(id);
			} else {
				System.out.println("ERROR user with id [ " + id 
						+ " ] not found");
			}
		} else {
			System.out.println("ERROR id is " + id);
		}
		return user;
	}

	@Override
	public List<User> getAllUsers() {
		List<User> usersList = null; 
		if (null != userData && !userData.isEmpty()) {
			System.out.println("trying to get all users data");
			usersList = new ArrayList<User>(userData.values());
		} else {
			System.out.println("ERROR user data is null or empty " + userData);
		}
		return usersList;
	}	

}
