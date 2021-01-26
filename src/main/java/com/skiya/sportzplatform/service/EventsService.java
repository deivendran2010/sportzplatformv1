package com.skiya.sportzplatform.service;

import java.util.List;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skiya.sportzplatform.domain.EventCategory;
import com.skiya.sportzplatform.domain.EventOrg;
import com.skiya.sportzplatform.domain.Events;
import com.skiya.sportzplatform.domain.Sports;
import com.skiya.sportzplatform.mapper.EventCategoryMapper;

import com.skiya.sportzplatform.mapper.EventsMapper;

@Service
public class EventsService {

	private final Logger log = LoggerFactory.getLogger(EventsService.class);

	@Autowired
	EventsMapper eventsmapper;
	
	public Events get(Integer eventId) {
		Events events = eventsmapper.selectByPrimaryKey(eventId);
		
		return events;
	}
	
	public Events getByName(String eventName) {
		Events sport = eventsmapper.selectByEventName(eventName);
		
		return sport;
	}
	
	public List<Events> getAll() {
		List<Events> sportList = eventsmapper.selectAll();
		if(Objects.nonNull(sportList)) {
			for(int a=0;a<sportList.size();a++) {
				Events sport = sportList.get(a);
				
			}
		}
		return sportList;
	}
	
	
	public int create(Events events) {
		Objects.requireNonNull(events, "Sports is mandatory to create");
		//log.debug("Sport object..." + events.toString());
		
		eventsmapper.insert(events);
		return events.getEventId();
	}
	
	public int update(Events events) {
		Objects.requireNonNull(events, "Events is mandatory to update");
		
		return eventsmapper.updateByPrimaryKey(events);
	}
	
	public int delete(Integer eventId) {
		Objects.requireNonNull(eventId, "Sports id is mandatory to delete");
		return eventsmapper.deleteByPrimaryKey(eventId);
	}
	
	
}