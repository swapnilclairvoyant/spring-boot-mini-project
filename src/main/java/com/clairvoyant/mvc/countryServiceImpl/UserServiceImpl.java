package com.clairvoyant.mvc.countryServiceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clairvoyant.mvc.countryService.UserService;
import com.clairvoyant.mvc.model.User;
import com.clairvoyant.mvc.repositories.UserRepositories;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepositories userRepo;

	@Override
	public List<User> getAllUser() {
		
		return userRepo.findAll();
	}

	@Override
	public boolean isUserExists(User user) {
		
		return false;//userRepo.findByName(user.getFirstName()) !=null;
	}

	@Override
	public User addUser(User user) {
		return userRepo.save(user);
	}

	@Override
	public User findById(Long id) {
		return userRepo.getOne(id);
	}

	@Override
	public void updateUser(User user) {
		addUser(user);
	}

	@Override
	public void deleteUserById(Long id) {
		
		userRepo.deleteById(id);
	}

}
