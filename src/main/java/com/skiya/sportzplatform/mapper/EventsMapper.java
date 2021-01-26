package com.skiya.sportzplatform.mapper;

import com.skiya.sportzplatform.domain.Events;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EventsMapper {
	int deleteByPrimaryKey(Integer eventId);

    int insert(Events record);

    Events selectByPrimaryKey(Integer eventId);
    
    Events selectByEventName(String eventName);

    List<Events> selectAll();

    int updateByPrimaryKey(Events record);
}