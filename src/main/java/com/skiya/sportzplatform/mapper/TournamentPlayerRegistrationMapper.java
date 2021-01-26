package com.skiya.sportzplatform.mapper;

import com.skiya.sportzplatform.domain.TournamentPlayerRegistration;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TournamentPlayerRegistrationMapper {
    int deleteByPrimaryKey(Integer tourPlayerRegId);

    int insert(TournamentPlayerRegistration record);

    TournamentPlayerRegistration selectByPrimaryKey(Integer tourPlayerRegId);

    List<TournamentPlayerRegistration> selectAll();

    int updateByPrimaryKey(TournamentPlayerRegistration record);
}