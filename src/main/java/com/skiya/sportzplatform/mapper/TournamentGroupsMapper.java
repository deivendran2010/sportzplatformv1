package com.skiya.sportzplatform.mapper;

import com.skiya.sportzplatform.domain.TournamentGroups;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TournamentGroupsMapper {
    int deleteByPrimaryKey(Integer groupId);

    int insert(TournamentGroups record);

    TournamentGroups selectByPrimaryKey(Integer groupId);

    List<TournamentGroups> selectAll();

    int updateByPrimaryKey(TournamentGroups record);
}