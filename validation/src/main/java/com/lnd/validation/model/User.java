package com.lnd.validation.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class User {
	
	@NotNull(message = "{validation.id.notnull.message}")
	private Long id;
	
	@NotNull(message = "{validation.userfname.notempty.message}")
	@NotEmpty(message = "{validation.userfname.notempty.message}")
	private String firstName;
	
	private String lastName;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
}
