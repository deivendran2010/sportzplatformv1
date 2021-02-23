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

import com.skiya.sportzplatform.domain.State;
import com.skiya.sportzplatform.dto.RestResponse;

import com.skiya.sportzplatform.service.StateService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/state")
public class StateResource {
	
	private final Logger log = LoggerFactory.getLogger(StateResource.class);
	
	@Autowired
	private StateService stateService;
	
	
	
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ResponseEntity<List<State>> getAllCompanies() {
		List<State> lookupList = stateService.getAll();
		if (Objects.isNull(lookupList)) {
			return new ResponseEntity<List<State>>(HttpStatus.OK);
		}
		return new ResponseEntity<List<State>>(lookupList, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getCompany(@PathVariable("id") Integer id) {
		log.debug("Company Id..." + id);
		State state = stateService.getCompany(id);
		if (Objects.isNull(state)) {
			log.error("state with type {} not found.", state);
			return new ResponseEntity<Object>(new RestResponse(false, "Company with type " + id + " not found"),
					HttpStatus.OK);
		}
		return new ResponseEntity<State>(state, HttpStatus.OK);
	}
	@RequestMapping(value = "/addState", method = RequestMethod.POST)
	public ResponseEntity<?> createSport(@RequestBody State state) {
		log.debug("createState() << sport={}", state);
		 State state1 = stateService.getCompanyByName(state.getStateName());
		if(Objects.nonNull(state1)) {
			log.error("Sports with same name exist.", state.getStateName());
			return new ResponseEntity<Object>(new RestResponse(false,"state Name "+ state.getStateName() + " already exist!"),
					HttpStatus.OK);
		}
		
		stateService.addCountry(state);
		log.debug("createcountryt() >> sport={}, rowsAdded={}", state);
		return Objects.nonNull(state.getStateId()) 
				? new ResponseEntity<State>(state, HttpStatus.CREATED)
				: new ResponseEntity<State>(HttpStatus.BAD_REQUEST);
	
	
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
	
	/*@RequestMapping(value = "/deleteState/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteCompany(@PathVariable("id") Integer stateId) {
		log.info("Fetching & Deleting Company with id {}", stateId);

		State existingCompany = stateService.getCompany(stateId);
		if (Objects.isNull(existingCompany)) {
			log.error("Unable to delete. Company with id {} not found.", stateId);
			return new ResponseEntity<Object>(new RestResponse(false,"Unable to delete. state with id " + stateId + " not found."),
					HttpStatus.OK);
		}
		stateService.deleteCompany(stateId);
		return new ResponseEntity<Object>(new RestResponse(true,"Company with id " + stateId + " deleted successfully."),
				HttpStatus.OK);
	}*/
	@RequestMapping(value = "/getingStatesCountryId/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getstate(@PathVariable("id") Integer id) {
		log.debug("Country Id..." + id);
		List<String> li = stateService.getstateCountry(id);
		if (Objects.isNull(li)) {
			log.error("state with type {} not found.", li);
			return new ResponseEntity<Object>(new RestResponse(false, "Country " + id + " not found"),
					HttpStatus.OK);
		}
		return new ResponseEntity<List<String>>(li, HttpStatus.OK);
	}
}

