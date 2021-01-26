package com.skiya.sportzplatform.web.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.skiya.sportzplatform.domain.Featured;
import com.skiya.sportzplatform.service.LandingService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/home")
public class LandingResource {

	private final Logger log = LoggerFactory.getLogger(LandingResource.class);

	@Autowired
	private LandingService landingService;

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ResponseEntity<List<Featured>> getAllSports() {
		List<Featured> featureds = landingService.getHomepage();
		if (featureds.isEmpty()) {
			return new ResponseEntity<List<Featured>>(HttpStatus.OK);
		}
		log.debug("Featured list size..." + featureds.size());
		return new ResponseEntity<List<Featured>>(featureds, HttpStatus.OK);
	}

}