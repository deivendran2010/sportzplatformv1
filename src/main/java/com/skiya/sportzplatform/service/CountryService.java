package com.skiya.sportzplatform.service;

import java.util.List;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.skiya.sportzplatform.domain.Company;
import com.skiya.sportzplatform.domain.Country;
import com.skiya.sportzplatform.mapper.CompanyMapper;
import com.skiya.sportzplatform.mapper.CountryMapper;

@Service
public class CountryService{
	
	private final Logger log = LoggerFactory.getLogger(CountryService.class);
	
	@Autowired
	private CountryMapper countryMapper;
	
	public List<Country> getAll() {
		List<Country> countries = countryMapper.selectAll();
		if(Objects.nonNull(countries)) {
			for(int a=0;a<countries.size();a++) {
				Country country = countries.get(a);
				
			}
		}
		return countries;
    }
	
public Country getCompany(Integer countryId) {
		Country country = countryMapper.selectByPrimaryKey(Objects.requireNonNull(countryId, "Company id is missing"));
		
		return country;
	}
	
	public Country getCompanyByName(String countryName) {
		Country country = countryMapper.selectByName(Objects.requireNonNull(countryName, "Company Email is missing"));
		
		return country;
	}
	
	@Transactional
	public int addCountry(Country country) {
		Objects.requireNonNull(country, "Country object is empty");
		log.debug("Country object..." + country.toString());
		countryMapper.insert(country);

				return country.getCountryId();
	}
	
	/*@Transactional
	public int updateCompany(Country country) {
		Objects.requireNonNull(country, "Country object is empty");
		Country country1 = countryMapper.selectByPrimaryKey(country.getCountryId());
	Objects.requireNonNull(country1, "Country object doesnt exist in database");
		
		return countryMapper.updateByPrimaryKey(country);
	}*/

	@Transactional
	public int deleteCompany(Integer id) {
		Objects.requireNonNull(id, "Company id is missing");
		Country country = countryMapper.selectByPrimaryKey(id);
		Objects.requireNonNull(country, "Company object doesnt exist in database");
		return countryMapper.deleteByPrimaryKey(id);
	}
	
}
