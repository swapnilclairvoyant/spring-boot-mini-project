package com.clairvoyant.mvc.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
import com.clairvoyant.mvc.exception.ServiceResponse;
import com.clairvoyant.mvc.exception.UserNotFoundException;
import com.clairvoyant.mvc.model.User;
import com.clairvoyant.mvc.utility.CustomErrorType;

@CrossOrigin( maxAge = 36600)
@RestController
@RequestMapping(value="/api")
public class UserController {
	private static final Logger logger = LogManager.getLogger(UserController.class);

	
	@Autowired
	UserService userService;
	
	@GetMapping("/users")
	public ResponseEntity<ServiceResponse<List<User>>> showAllUsers() {
		logger.debug("Inside showAllUsers");
//		return userService.getAllUser();
		return ResponseEntity.ok().body(new ServiceResponse<List<User>>( userService.getAllUser()));
	}
	
	@PostMapping("/users")
	public ResponseEntity<ServiceResponse<User>> addUser(@RequestBody User user) {
		logger.debug("Inside addUser");
		//return userService.addUser(user);
		return ResponseEntity.ok().body(new ServiceResponse<User>( userService.addUser(user)));
	}
	
	@PutMapping("/users/{id}") 
	public ResponseEntity<ServiceResponse<User>> updateUser(@PathVariable("id") Long id, @RequestBody User user) {
		User currentUser = userService.findById(id);
		/*if(currentUser == null) {
			try {
				throw new UserNotFoundException("User with id: "+id+" not found in DB");
			} catch (UserNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}*/
		currentUser.setFirstName(user.getFirstName());
		currentUser.setLastName(user.getLastName());
		currentUser.setPhoneNo(user.getPhoneNo());
		currentUser.setCity(user.getCity());
		userService.updateUser(currentUser);
		return ResponseEntity.ok().body(new ServiceResponse<User>( currentUser));
	}
	
	@DeleteMapping("users/{id}")
	public Object deleteUser(@PathVariable("id") Long id) {
		userService.deleteUserById(id);
		return "";
	}
}
