package com.skiya.sportzplatform.service;

import java.util.List;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skiya.sportzplatform.domain.EventCategory;
import com.skiya.sportzplatform.domain.EventOrg;
import com.skiya.sportzplatform.domain.Sports;
import com.skiya.sportzplatform.mapper.EventCategoryMapper;
//import com.skiya.sportzplatform.mapper.SportsMapper;

@Service
public class EventCategoryService extends AbstractBaseService{
	
	private final Logger log = LoggerFactory.getLogger(SportsService.class);

	@Autowired
	EventCategoryMapper eventcategoryMapper;
	
	public int create(EventCategory eventcategory) {
		Objects.requireNonNull(eventcategory, "eventcategory is mandatory to create");
		log.debug("Sport object..." + eventcategoryMapper.toString());
		
		eventcategoryMapper.insert(eventcategory);
		return eventcategory.getEventCategoryId();
	}
	
	public EventCategory get(Integer eventCategoryId) {
		EventCategory eventcategory = eventcategoryMapper.selectByPrimaryKey(eventCategoryId);
		
		return eventcategory;
	}
	
	public EventCategory getByName(String eventCategoryName) {
		EventCategory eventcategory = eventcategoryMapper.selectByEventCategoryName(eventCategoryName);
		
		return eventcategory;
	}
	
	public List<EventCategory> getAll() {
		List<EventCategory> sportList = eventcategoryMapper.selectAll();
		if(Objects.nonNull(sportList)) {
			for(int a=0;a<sportList.size();a++) {
				EventCategory eventorg = sportList.get(a);
				
			}
		}
		return sportList;
	}
	
	
	public int update(EventCategory eventorg) {
		Objects.requireNonNull(eventorg, "EventCategory is mandatory to update");
		
		return eventcategoryMapper.updateByPrimaryKey(eventorg);
	}
	
	public int delete(Integer eventCategoryId) {
		Objects.requireNonNull(eventCategoryId, "Sports id is mandatory to delete");
		return eventcategoryMapper.deleteByPrimaryKey(eventCategoryId);
	}
	
}
