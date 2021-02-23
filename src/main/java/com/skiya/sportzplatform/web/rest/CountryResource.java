package com.skiya.sportzplatform.web.rest;

import java.util.List;
import java.util.Objects;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.skiya.sportzplatform.domain.Country;
import com.skiya.sportzplatform.dto.RestResponse;
import com.skiya.sportzplatform.service.CountryService;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/country")
public class CountryResource {
	
	private final Logger log = LoggerFactory.getLogger(CountryResource.class);
	
	@Autowired
	private CountryService countryService;
	
	
	
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ResponseEntity<List<Country>> getAllCompanies() {
		List<Country> lookupList = countryService.getAll();
		if (Objects.isNull(lookupList)) {
			return new ResponseEntity<List<Country>>(HttpStatus.OK);
		}
		return new ResponseEntity<List<Country>>(lookupList, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getCompany(@PathVariable("id") Integer id) {
		log.debug("Company Id..." + id);
		Country company = countryService.getCompany(id);
		if (Objects.isNull(company)) {
			log.error("Company with type {} not found.", company);
			return new ResponseEntity<Object>(new RestResponse(false, "Company with type " + id + " not found"),
					HttpStatus.OK);
		}
		return new ResponseEntity<Country>(company, HttpStatus.OK);
	}
	@RequestMapping(value = "/addCountry", method = RequestMethod.POST)
	public ResponseEntity<?> createSport(@RequestBody Country country) {
		log.debug("createSport() << sport={}", country);
		Country country1 = countryService.getCompanyByName(country.getCountryName());
		if(Objects.nonNull(country1)) {
			log.error("Sports with same name exist.", country.getCountryName());
			return new ResponseEntity<Object>(new RestResponse(false,"country Name "+ country.getCountryName() + " already exist!"),
					HttpStatus.OK);
		}
		
		countryService.addCountry(country);
		log.debug("createcountryt() >> sport={}, rowsAdded={}", country);
		return Objects.nonNull(country.getCountryId()) 
				? new ResponseEntity<Country>(country, HttpStatus.CREATED)
				: new ResponseEntity<Country>(HttpStatus.BAD_REQUEST);
	
	
	}
	
/*	@RequestMapping(value = "/updateCompany/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateCompany(@PathVariable("id") Integer countryId, 
			@RequestBody Country country) {
		log.debug("Updating Company for id " + countryId);
		country.setCountryId(countryId);
		Country existingCompany = countryService.getCompany(countryId);
		if (Objects.isNull(existingCompany)) {
			log.error("Unable to update. Company with id {} not found.", countryId);
			return new ResponseEntity<Object>(new RestResponse(false,"Unable to update. Company with id " + countryId + " not found."),
					HttpStatus.OK);
		}
		countryService.updateCompany(country);
		return new ResponseEntity<Object>(new RestResponse(true,"Country with id " + countryId + " updated successfully."),
				HttpStatus.OK);
	}*/
	
	@RequestMapping(value = "/deleteCompany/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteCompany(@PathVariable("id") Integer countryId) {
		log.info("Fetching & Deleting Company with id {}", countryId);

		Country existingCompany = countryService.getCompany(countryId);
		if (Objects.isNull(existingCompany)) {
			log.error("Unable to delete. Company with id {} not found.", countryId);
			return new ResponseEntity<Object>(new RestResponse(false,"Unable to delete. Company with id " + countryId + " not found."),
					HttpStatus.OK);
		}
		countryService.deleteCompany(countryId);
		return new ResponseEntity<Object>(new RestResponse(true,"Company with id " + countryId + " deleted successfully."),
				HttpStatus.OK);
	}

}
