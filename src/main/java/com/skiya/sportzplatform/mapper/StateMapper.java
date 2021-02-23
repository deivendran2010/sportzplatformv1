package com.skiya.sportzplatform.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;


import com.skiya.sportzplatform.domain.State;
@Mapper
public interface StateMapper {
	
	
	
	 int deleteByPrimaryKey(Integer stateId);

	   int insert(State record);

	   State selectByPrimaryKey(Integer stateId);

	    List<State> selectAll();

	    int updateByPrimaryKey(State record);

	    State selectByName(String stateName);
	    //List<String> getstateByCountry(Integer countryId);

		List<String> getstateByCountry(Integer id);
	

}
