package com.lnd.custom.error.response.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.lnd.custom.error.response.exception.UserDataNotFoundException;
import com.lnd.custom.error.response.model.User;
import com.lnd.custom.error.response.service.UserDataService;

@RestController
@RequestMapping("/userdata/v2")
public class UserDataController {
	
	@Autowired
	private UserDataService userDataService;
	
	@PostMapping(path = "/adduser")
	public ResponseEntity<Object> createUser(@RequestBody final User user) {
		ResponseEntity<Object> responseEntity = null;
		User addedUser = userDataService.addUser(user);
		if (null != addedUser) {
			URI location = ServletUriComponentsBuilder.fromCurrentContextPath()
					.path("/userdata/v1/getuser/{id}")
					.buildAndExpand(addedUser.getId()).toUri();
			responseEntity = ResponseEntity.created(location).build();
		} else {
			responseEntity = ResponseEntity.badRequest().build();
		}
		return responseEntity;
	}
	
	@GetMapping(path = "/getuser/{id}")
	public ResponseEntity<Object> getUserData(
										@PathVariable("id") final Long id) {
		ResponseEntity<Object> responseEntity = null;
		User user = userDataService.getUser(id); 
		if (null != user) {
			responseEntity = ResponseEntity.ok(user); 
		} else {
			//responseEntity = ResponseEntity.notFound().build();
			throw new RuntimeException("custom error test");
		}		
		return responseEntity; 
	}
	
	@GetMapping(path = "/getallusers")
	public ResponseEntity<Object> getAllUsers() {
		ResponseEntity<Object> responseEntity = null;
		List<User> usersList = userDataService.getAllUsers();
		if (null != usersList) {
			responseEntity = ResponseEntity.ok(usersList);
		} else {
			//responseEntity = ResponseEntity.notFound().build();
			throw new UserDataNotFoundException("There are no users at all");
		}
		return responseEntity;
	}
}
