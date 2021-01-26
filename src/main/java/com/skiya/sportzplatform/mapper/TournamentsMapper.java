package com.skiya.sportzplatform.mapper;

import com.skiya.sportzplatform.domain.Tournaments;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TournamentsMapper {
    int deleteByPrimaryKey(Integer tournamentId);

    int insert(Tournaments record);

    Tournaments selectByPrimaryKey(Integer tournamentId);

    List<Tournaments> selectAll();

    int updateByPrimaryKey(Tournaments record);
}