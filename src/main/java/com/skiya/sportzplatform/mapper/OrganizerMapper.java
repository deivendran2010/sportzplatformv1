package com.skiya.sportzplatform.mapper;

import com.skiya.sportzplatform.domain.Organizer;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrganizerMapper {
    int deleteByPrimaryKey(Integer organizerId);

    int insert(Organizer record);

    Organizer selectByPrimaryKey(Integer organizerId);
    
    Organizer selectEmail(String email);

    List<Organizer> selectAll();

    int updateByPrimaryKey(Organizer record);
}