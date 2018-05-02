package com.clairvoyant.mvc.countryService;

import java.util.List;

import com.clairvoyant.mvc.model.Country;

public interface CountryService {
	public List<Country> getAllCountries();
	public Country getSelectedCountry(Long id);
	public boolean isCountryExists(Country country);
	public void saveCountry(Country country);
	public Country findById(Long id);
	void updateCountry(Country country);
	void deleteUserById(Long id);
}
