package com.skiya.sportzplatform.service;

import java.util.List;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skiya.sportzplatform.domain.EventOrg;
import com.skiya.sportzplatform.domain.Sports;
//import com.skiya.sportzplatform.domain.Sports;
import com.skiya.sportzplatform.mapper.EventOrgMapper;

@Service
public class EventOrgService {

	private final Logger log = LoggerFactory.getLogger(EventOrgService.class);

	@Autowired
	EventOrgMapper eventorgmapper;
	
	public int create(EventOrg eventorg) {
		Objects.requireNonNull(eventorg, "Sports is mandatory to create");
		log.debug("Sport object..." + eventorg.toString());
		
		eventorgmapper.insert(eventorg);
		return eventorg.getEventOrganizerId();
	}
	
	public EventOrg get(Integer eventOrganizerId) {
		EventOrg eventorg = eventorgmapper.selectByPrimaryKey(eventOrganizerId);
		
		return eventorg;
	}
	
	public EventOrg getByName(String sportsName) {
		EventOrg eventorg = eventorgmapper.selectBySportsName(sportsName);
		
		return eventorg;
	}
	
	public List<EventOrg> getAll() {
		List<EventOrg> sportList = eventorgmapper.selectAll();
		if(Objects.nonNull(sportList)) {
			for(int a=0;a<sportList.size();a++) {
				EventOrg eventorg = sportList.get(a);
				
			}
		}
		return sportList;
	}
	
	
	public int update(EventOrg eventorg) {
		Objects.requireNonNull(eventorg, "Sports is mandatory to update");
		
		return eventorgmapper.updateByPrimaryKey(eventorg);
	}
	
	public int delete(Integer eventOrganizerId) {
		Objects.requireNonNull(eventOrganizerId, "Sports id is mandatory to delete");
		return eventorgmapper.deleteByPrimaryKey(eventOrganizerId);
	}
	
}
