package com.skiya.sportzplatform.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.skiya.sportzplatform.domain.City;
import com.skiya.sportzplatform.domain.State;

@Mapper
public interface CityMapper {
	
	
	
	 int deleteByPrimaryKey(Integer cityId);

	   int insert(City record);

	   City selectByPrimaryKey(Integer cityId);

	    List<City> selectAll();

	    int updateByPrimaryKey(City record);

	    City selectByName(String cityName);
	    //List<String> getstateByCountry(Integer countryId);

		

		List<String> getcityByState(Integer id);
	

}
