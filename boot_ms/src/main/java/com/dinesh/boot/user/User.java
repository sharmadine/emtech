package com.dinesh.boot.user;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class User extends ResourceSupport {
	private final String iUserName;
	
	@JsonCreator
	public  User(@JsonProperty("userName") String userName) {
		this.iUserName = userName;
	}
	
	public String getUserName() {
		return this.iUserName;
	}
}
