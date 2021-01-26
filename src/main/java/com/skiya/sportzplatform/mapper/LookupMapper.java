package com.skiya.sportzplatform.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.skiya.sportzplatform.domain.Lookup;

@Mapper
public interface LookupMapper {

	List<Lookup> selectByLookupType(String lookupType);
	
	Lookup selectByLookupKeyType(Lookup lookup);
	
	List<Lookup> allLookups();
	
	void addLookup(Lookup lookup);
	
	void updateLookup(Lookup lookup);
	
	void deleteLookup(Lookup lookup);
	
}
