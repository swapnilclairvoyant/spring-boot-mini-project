package com.clairvoyant.mvc.countryService;

import java.util.List;

import com.clairvoyant.mvc.model.User;

public interface UserService {
	public List<User> getAllUser();
	public boolean isUserExists(User user);
	void addUser(User user);
	public User findById(Long id);
	void updateUser(User user);
	void deleteUserById(Long id);
}
