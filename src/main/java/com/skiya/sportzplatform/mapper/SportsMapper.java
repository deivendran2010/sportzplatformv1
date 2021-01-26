package com.skiya.sportzplatform.mapper;

import com.skiya.sportzplatform.domain.Sports;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SportsMapper {
    int deleteByPrimaryKey(Integer sportsId);

    int insert(Sports record);

    Sports selectByPrimaryKey(Integer sportsId);
    
    Sports selectBySportsName(String sportsName);

    List<Sports> selectAll();

    int updateByPrimaryKey(Sports record);
}