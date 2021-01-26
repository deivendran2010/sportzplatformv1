package com.skiya.sportzplatform.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.skiya.sportzplatform.domain.EventOrg;

//import com.skiya.sportzplatform.domain.Sports;
@Mapper
public interface EventOrgMapper {
	
	
	
	int deleteByPrimaryKey(Integer event_organizer_id);

    int insert(EventOrg record);

    EventOrg selectByPrimaryKey(Integer event_organizer_id);
    
    EventOrg selectBySportsName(String sportsName);

    List<EventOrg> selectAll();

    int updateByPrimaryKey(EventOrg record);

}
