package com.clairvoyant.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.clairvoyant.mvc.countryService.CountryService;
import com.clairvoyant.mvc.model.Country;
import com.clairvoyant.mvc.utility.CustomErrorType;

@RestController
public class CountryController {
	@Autowired
	CountryService cservice;
	
	@RequestMapping(value="/countries")
	public List<Country> showAllCountrues() {
		return cservice.getAllCountries();
	}
	
	@RequestMapping("/country/{id}")
	public Country showCountry(@PathVariable("id") Long id) {
		return cservice.getSelectedCountry(id);
	}
	
	@RequestMapping(value="/country", method=RequestMethod.POST)
	public ResponseEntity<?> createCountry(@RequestBody Country country) {
		if(cservice.isCountryExists(country)) {
			return new ResponseEntity(new CustomErrorType("Unable to create. A Country with name "+country.getCountryName()+" already exist."),HttpStatus.CONFLICT);
		}
		cservice.saveCountry(country);
		
		return new ResponseEntity<Country>(country,HttpStatus.CREATED); 
			
	}
	
	@RequestMapping(value="/country/{id}", method=RequestMethod.PUT)
	public ResponseEntity<?> updateCoutry(@RequestBody Country country, @PathVariable("id") long id) {
			Country currentCountry = cservice.findById(id);
			if(currentCountry==null) {
				return new ResponseEntity(new CustomErrorType("Unable to upate. Country with id " + id + " not found."),HttpStatus.NOT_FOUND);
			}
			currentCountry.setCountryName(country.getCountryName());
			cservice.updateCountry(currentCountry);
			return new ResponseEntity<Country>(currentCountry,HttpStatus.OK);
	}
	
	@RequestMapping(value="/country/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<?> deleteCountry(@PathVariable("id") long id) {
		Country country = cservice.findById(id);
		if (country == null) {
            return new ResponseEntity(new CustomErrorType("Unable to delete. Country with id " + id + " not found."),HttpStatus.NOT_FOUND);
            
        }
		cservice.deleteUserById(id);
        return new ResponseEntity<Country>(HttpStatus.NO_CONTENT);
	}
	
	
	
}
