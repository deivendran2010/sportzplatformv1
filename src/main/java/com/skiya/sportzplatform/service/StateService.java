package com.skiya.sportzplatform.service;

import java.util.List;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.skiya.sportzplatform.domain.State;

import com.skiya.sportzplatform.mapper.StateMapper;

@Service
public class StateService {
	
	private final Logger log = LoggerFactory.getLogger(StateService.class);
	
	@Autowired
	private StateMapper stateMapper;
	
	public List<State> getAll() {
		List<State> countries = stateMapper.selectAll();
		if(Objects.nonNull(countries)) {
			for(int a=0;a<countries.size();a++) {
				State state = countries.get(a);
				
			}
		}
		return countries;
    }
	
public State getCompany(Integer stateId) {
	State state = stateMapper.selectByPrimaryKey(Objects.requireNonNull(stateId, "Company id is missing"));
		
		return state;
	}
	
	public State getCompanyByName(String stateName) {
		State state = stateMapper.selectByName(Objects.requireNonNull(stateName, "Company Email is missing"));
		
		return state;
	}
	
	@Transactional
	public int addCountry(State state) {
		Objects.requireNonNull(state, "state object is empty");
		log.debug("state object..." + state.toString());
		stateMapper.insert(state);

				return state.getStateId();
	}

	public List<String> getstateCountry(Integer id) {
		// TODO Auto-generated method stub
List<String> g=stateMapper.getstateByCountry(id);
		return g;
	}
	
	/*@Transactional
	public int updateCompany(Country country) {
		Objects.requireNonNull(country, "Country object is empty");
		Country country1 = countryMapper.selectByPrimaryKey(country.getCountryId());
	Objects.requireNonNull(country1, "Country object doesnt exist in database");
		
		return countryMapper.updateByPrimaryKey(country);
	}*/

/*	@Transactional
	public int deleteCompany(Integer id) {
		Objects.requireNonNull(id, "state id is missing");
		State state=stateMapper.selectByPrimaryKey(id);
		Objects.requireNonNull(state, "Company object doesnt exist in database");
		return stateMapper.deleteByPrimaryKey(id);
	}*/
	
}
