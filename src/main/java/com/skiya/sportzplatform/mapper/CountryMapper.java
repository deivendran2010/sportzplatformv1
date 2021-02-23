package com.skiya.sportzplatform.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.skiya.sportzplatform.domain.Address;
import com.skiya.sportzplatform.domain.Company;
import com.skiya.sportzplatform.domain.Country;
@Mapper
public interface CountryMapper {

	 int deleteByPrimaryKey(Integer countryId);

	   int insert(Country record);

	    Country selectByPrimaryKey(Integer countryId);

	    List<Country> selectAll();

	    int updateByPrimaryKey(Country record);

		Country selectByName(String countryName);
	
}
