package com.skiya.sportzplatform.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public abstract class AbstractBaseService {
	
	private final Logger log = LoggerFactory.getLogger(AbstractBaseService.class);
	
	protected <T> T toJson(String content, Class<T> valueType) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			return (T) mapper.readValue(content,valueType);
		}catch(JsonProcessingException ex) {
			ex.printStackTrace();
			log.error("Exception in JsonType conversion" + ex.getMessage());
		}
		return null;
	}
}
