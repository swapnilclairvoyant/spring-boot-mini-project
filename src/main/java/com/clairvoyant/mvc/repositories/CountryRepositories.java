package com.clairvoyant.mvc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clairvoyant.mvc.model.Country;

@Repository
public interface CountryRepositories extends JpaRepository<Country, Long>{
	//Country findByName(String name);
}
