package com.skiya.sportzplatform.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.skiya.sportzplatform.domain.EventCategory;
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
		
		
		
		//ObjectMapper mapper = new ObjectMapper();
		Events user = new Events();
		
		OutputStream out = null;
		try {
			out = new FileOutputStream("c:\\work\\user.json");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 try {
			new ObjectMapper().writeValue(out,user);
			// String jsonStr = new ObjectMapper().writeValueAsString(user);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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