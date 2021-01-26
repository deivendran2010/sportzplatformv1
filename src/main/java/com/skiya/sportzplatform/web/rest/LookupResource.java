package com.skiya.sportzplatform.web.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.skiya.sportzplatform.domain.Lookup;
import com.skiya.sportzplatform.dto.RestResponse;
import com.skiya.sportzplatform.service.LookupService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/lookup")
public class LookupResource {

	private final Logger log = LoggerFactory.getLogger(LookupResource.class);

	@Autowired
	private LookupService lookupService;

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ResponseEntity<List<Lookup>> getAllLookups() {
		List<Lookup> lookupList = lookupService.getAll();
		if (lookupList.isEmpty()) {
			return new ResponseEntity<List<Lookup>>(HttpStatus.OK);
		}
		return new ResponseEntity<List<Lookup>>(lookupList, HttpStatus.OK);
	}

	@RequestMapping(value = "/{lookupType}", method = RequestMethod.GET)
	public ResponseEntity<?> getLookup(@PathVariable("lookupType") String lookupType) {
		log.debug("Lookup Id..." + lookupType);
		List<Lookup> lookupList = lookupService.getByLookupType(lookupType);
		if (lookupList == null) {
			log.error("Lookup with type {} not found.", lookupType);
			return new ResponseEntity<Object>(new RestResponse(false, "Lookup with type " + lookupType + " not found"),
					HttpStatus.OK);
		}
		return new ResponseEntity<List<Lookup>>(lookupList, HttpStatus.OK);
	}

}