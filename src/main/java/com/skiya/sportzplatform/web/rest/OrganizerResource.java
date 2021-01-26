package com.skiya.sportzplatform.web.rest;

import java.util.List;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.skiya.sportzplatform.domain.Organizer;
import com.skiya.sportzplatform.dto.RestResponse;
import com.skiya.sportzplatform.service.OrganizerService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/organizer")
public class OrganizerResource {
	
	private final Logger log = LoggerFactory.getLogger(OrganizerResource.class);
	
	@Autowired
	private OrganizerService organizerService;
	
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ResponseEntity<List<Organizer>> getAllCompanies() {
		List<Organizer> organizerList = organizerService.getAll();
		if (organizerList.isEmpty()) {
			return new ResponseEntity<List<Organizer>>(HttpStatus.OK);
		}
		return new ResponseEntity<List<Organizer>>(organizerList, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getOrganizer(@PathVariable("id") Integer id) {
		log.debug("Organizer Id..." + id);
		Organizer organizer = organizerService.getOrganizer(id);
		if (Objects.isNull(organizer)) {
			log.error("Organizer with type {} not found.", organizer);
			return new ResponseEntity<Object>(new RestResponse(false, "Organizer with type " + id + " not found"),
					HttpStatus.OK);
		}
		return new ResponseEntity<Organizer>(organizer, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/addOrganizer", method = RequestMethod.POST)
	public ResponseEntity<?> addOrganizer(@RequestBody Organizer organizer, HttpServletRequest request) {
		log.debug("Organizer Details..." + organizer.toString());
		Organizer existingOrganizer = organizerService.getOrganizerByEmail(organizer.getEmail());
		if(Objects.nonNull(existingOrganizer)) {
			log.error("Organizer with same email addreess exist.", organizer.getEmail());
			return new ResponseEntity<Object>(new RestResponse(false,"Email Address "+ organizer.getEmail() + " already in use!"),
					HttpStatus.OK);
		}
		organizerService.addOrganizer(organizer);
		return new ResponseEntity<Object>(new RestResponse(true,"Organizer with id " + organizer.getOrganizerId() + " created successfully."),
				HttpStatus.OK);
    }
	
	@RequestMapping(value = "/updateOrganizer/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateOrganizer(@PathVariable("id") Integer companyId, 
			@RequestBody Organizer company) {
		log.debug("Updating Organizer for id " + companyId);
		company.setOrganizerId(companyId);
		Organizer existingOrganizer = organizerService.getOrganizer(companyId);
		if (Objects.isNull(existingOrganizer)) {
			log.error("Unable to update. Organizer with id {} not found.", companyId);
			return new ResponseEntity<Object>(new RestResponse(false,"Unable to update. Organizer with id " + companyId + " not found."),
					HttpStatus.OK);
		}
		organizerService.updateOrganizer(company);
		return new ResponseEntity<Object>(new RestResponse(true,"Organizer with id " + companyId + " updated successfully."),
				HttpStatus.OK);
	}
	
	@RequestMapping(value = "/deleteOrganizer/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteOrganizer(@PathVariable("id") Integer companyId) {
		log.info("Fetching & Deleting Organizer with id {}", companyId);

		Organizer existingOrganizer = organizerService.getOrganizer(companyId);
		if (Objects.isNull(existingOrganizer)) {
			log.error("Unable to delete. Organizer with id {} not found.", companyId);
			return new ResponseEntity<Object>(new RestResponse(false,"Unable to delete. Organizer with id " + companyId + " not found."),
					HttpStatus.OK);
		}
		organizerService.deleteOrganizer(companyId);
		return new ResponseEntity<Object>(new RestResponse(true,"Organizer with id " + companyId + " deleted successfully."),
				HttpStatus.OK);
	}

}
