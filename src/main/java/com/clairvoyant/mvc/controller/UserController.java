package com.clairvoyant.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clairvoyant.mvc.countryService.UserService;
import com.clairvoyant.mvc.model.User;
import com.clairvoyant.mvc.utility.CustomErrorType;

@CrossOrigin( maxAge = 36600)
@RestController
@RequestMapping(value="/api")
public class UserController {
	@Autowired
	UserService userService;
	
	@GetMapping("/users")
	public List<User> showAllUsers() {
		System.out.println("Inside showAllUsers");
		return userService.getAllUser();
	}
	
	@PostMapping("/users")
	public Object addUser(@RequestBody User user) {
		System.out.println("Inside addUser");
		if(userService.isUserExists(user)) {
			return new CustomErrorType("Unable to create. A Country with name "+user.getFirstName()+" "+user.getLastName()+" already exist.");
		}
		userService.addUser(user);
		return "";
	}
	
	@PutMapping("/users/{id}") 
	public Object updateUser(@PathVariable("id") Long id, @RequestBody User user) {
		User currentUser = userService.findById(id);
		if(currentUser == null) {
			return new CustomErrorType("Unable to upate. User with id " + id + " not found.");
		}
		currentUser.setFirstName(user.getFirstName());
		currentUser.setLastName(user.getLastName());
		currentUser.setPhoneNo(user.getPhoneNo());
		currentUser.setCity(user.getCity());
		userService.updateUser(currentUser);
		return currentUser;
	}
	
	@DeleteMapping("users/{id}")
	public Object deleteUser(@PathVariable("id") Long id) {
		User user = userService.findById(id);
		if(user==null) {
			return new CustomErrorType("Unable to delete. User with id " + id + " not found.");
		}
		
		userService.deleteUserById(id);
		return "";
	}
}
