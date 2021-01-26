package com.skiya.sportzplatform.mapper;

import com.skiya.sportzplatform.domain.EventOrganizer;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EventOrganizerMapper {
    int deleteByPrimaryKey(Integer eventOrganizerId);

    int insert(EventOrganizer record);

    EventOrganizer selectByPrimaryKey(Integer eventOrganizerId);
    EventOrganizer selectByprimaryContactName(String primaryContactName);

    List<EventOrganizer> selectAll();

    int updateByPrimaryKey(EventOrganizer record);
}