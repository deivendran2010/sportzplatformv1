package com.skiya.sportzplatform.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.skiya.sportzplatform.domain.Lookup;
import com.skiya.sportzplatform.mapper.LookupMapper;

@Service
public class LookupService {
	
	private final Logger log = LoggerFactory.getLogger(LookupService.class);
	
	@Autowired
	private LookupMapper lookupMapper;
	
//	@Autowired
//	private LookupTableMapper LookupTableMapper;
//	
//	@Autowired
//	private LookupTypeMapper lookupTypeMapper;
	
	public List<Lookup> getAll() {
		List<Lookup> lookupDTOList = lookupMapper.allLookups();
		log.debug("Lookup list..." + lookupDTOList.size());
		return lookupDTOList;
    }
	
	public List<Lookup> getByLookupType(String lookupType) {
		List<Lookup> lookupDTOList = lookupMapper.selectByLookupType(lookupType);
		log.debug("Lookup list..." + lookupDTOList.size());
		return lookupDTOList;
    }
	
	public Lookup getByLookupKeyType(Lookup lookupDTO) {
		return lookupMapper.selectByLookupKeyType(lookupDTO);
	}
	
	@Transactional
	public Lookup addLookup(Lookup lookup) {
		lookupMapper.addLookup(lookup);
		return lookup;
	}
	
	@Transactional
	public Lookup updateLookup(Lookup lookupDTO) {
		Lookup lookup = lookupMapper.selectByLookupKeyType(lookupDTO);
		if(lookup != null) {
			lookupMapper.updateLookup(lookup);
			log.debug("Update Lookup Successful...");
		}
		return lookupDTO;
	}
	
	@Transactional
	public void deleteLookup(Lookup lookupDTO) {
		Lookup lookup = lookupMapper.selectByLookupKeyType(lookupDTO);
		if(lookup != null) {
			lookupMapper.deleteLookup(lookup);
		}
		log.debug("Delete Successful...");
	}
}
