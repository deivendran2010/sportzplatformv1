package com.skiya.sportzplatform.mapper;

import com.skiya.sportzplatform.domain.TournamentRegistrations;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TournamentRegistrationsMapper {
    int deleteByPrimaryKey(Integer registrationId);

    int insert(TournamentRegistrations record);

    TournamentRegistrations selectByPrimaryKey(Integer registrationId);

    List<TournamentRegistrations> selectAll();

    int updateByPrimaryKey(TournamentRegistrations record);
}