package com.skiya.sportzplatform.mapper;

import com.skiya.sportzplatform.domain.EventCategory;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EventCategoryMapper {
    int deleteByPrimaryKey(Integer eventCategoryId);

    int insert(EventCategory record);

    EventCategory selectByPrimaryKey(Integer eventCategoryId);
    EventCategory selectByEventCategoryName(String eventCategoryName);

    List<EventCategory> selectAll();

    int updateByPrimaryKey(EventCategory record);
}