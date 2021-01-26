package com.skiya.sportzplatform.mapper;

import com.skiya.sportzplatform.domain.TeamPlayer;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TeamPlayerMapper {
    int deleteByPrimaryKey(Integer teamPlayerId);

    int insert(TeamPlayer record);

    TeamPlayer selectByPrimaryKey(Integer teamPlayerId);

    List<TeamPlayer> selectAll();

    int updateByPrimaryKey(TeamPlayer record);
}