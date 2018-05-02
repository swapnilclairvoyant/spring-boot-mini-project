package com.clairvoyant.mvc.countryServiceImpl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clairvoyant.mvc.countryService.CountryService;
import com.clairvoyant.mvc.model.Country;
import com.clairvoyant.mvc.repositories.CountryRepositories;
import com.clairvoyant.mvc.utility.Utilities;


@Service
@Transactional
public class CountryServiceImpl implements CountryService {
	/*@Autowired
	Utilities util;*/
	
	@Autowired
	CountryRepositories countryRepo;
	
	public List<Country> getAllCountries() {

		return countryRepo.findAll();//util.createCountryList();
	}
	public Country getSelectedCountry(Long id) {
		
		return findById(id);//util.createCountryList().stream().filter(s->s.getId()==id).findFirst().orElse(null);
	}
	
	
	
	@Override
	public boolean isCountryExists(Country country) {
		
		return false;
	}
	@Override
	public void saveCountry(Country country) {
		
		countryRepo.save(country);
		
	}
	@Override
	public Country findById(Long id) {
		
		return countryRepo.getOne(id);
	}
	@Override
	public void updateCountry(Country country) {
		saveCountry(country);
		
	}
	@Override
	public void deleteUserById(Long id) {
		countryRepo.deleteById(id);
			
	}
	
	
}
