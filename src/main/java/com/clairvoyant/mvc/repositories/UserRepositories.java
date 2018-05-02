package com.clairvoyant.mvc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clairvoyant.mvc.model.User;

@Repository
public interface UserRepositories extends JpaRepository<User, Long>{
	//User findByName(String name);
}
