package com.dinesh.boot.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dinesh.boot.user.User;

@RestController
public class UserController {
	private static final String TEMPLATE = "Hello %s!";
	
	@RequestMapping("/user")
	public HttpEntity<User> user(
		@RequestParam(value = "name" , required = false, defaultValue = "Dinesh") String aUserName) {
		User tUser = new User(String.format(TEMPLATE, aUserName));
		tUser.add(linkTo(methodOn(UserController.class).user(aUserName)).withSelfRel());
		return new ResponseEntity<User>(tUser, HttpStatus.OK);
	}

}
