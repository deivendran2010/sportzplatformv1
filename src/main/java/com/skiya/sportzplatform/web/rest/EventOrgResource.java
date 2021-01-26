package com.skiya.sportzplatform.web.rest;

import static java.util.Objects.isNull;

import java.util.List;
import java.util.Objects;

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

import com.skiya.sportzplatform.domain.EventOrg;
import com.skiya.sportzplatform.domain.Sports;
import com.skiya.sportzplatform.dto.RestResponse;
import com.skiya.sportzplatform.service.EventOrgService;
import com.skiya.sportzplatform.service.SportsService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/event")
public class EventOrgResource {

	private final Logger log = LoggerFactory.getLogger(EventOrgResource.class);

	@Autowired
	private EventOrgService eventorgservice;
	
	
	
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ResponseEntity<List<EventOrg>> getAllSports() {
		List<EventOrg> lookupList = eventorgservice.getAll();
		if (lookupList.isEmpty()) {
			return new ResponseEntity<List<EventOrg>>(HttpStatus.OK);
		}
		return new ResponseEntity<List<EventOrg>>(lookupList, HttpStatus.OK);
	}

	@RequestMapping(value = "/{eventOrganizerId}", method = RequestMethod.GET)
	public ResponseEntity<EventOrg> getSport(@PathVariable("eventOrganizerId") Integer eventOrganizerId) {
		log.debug("getSport() << sportsId={}", eventOrganizerId);

		EventOrg eventorg = eventorgservice.get(eventOrganizerId);
		log.debug("getSport() >> sportsId={}, sport={}", eventOrganizerId, eventorg);

		return Objects.nonNull(eventorg) && Objects.nonNull(eventorg.getEventOrganizerId())
				? new ResponseEntity<EventOrg>(eventorg, HttpStatus.OK)
				: new ResponseEntity<EventOrg>(HttpStatus.OK);
	}
	
	
	
	
	
	@RequestMapping(value = "/addEventOrganizer", method = RequestMethod.POST)
	public ResponseEntity<?> createSport(@RequestBody EventOrg eventorg) {
		log.debug("createSport() << sport={}", eventorg);
		//EventOrg eventorg1 = eventorgservice.getByName(sport.getSportsName());
		eventorgservice.create(eventorg);
		log.debug("createSport() >> sport={}, rowsAdded={}", eventorg);
		return Objects.nonNull(eventorg.getEventOrganizerId()) 
				? new ResponseEntity<EventOrg>(eventorg, HttpStatus.CREATED)
				: new ResponseEntity<EventOrg>(HttpStatus.BAD_REQUEST);
	}
	
	@RequestMapping(value = "/updateEventOrganizer/{id}", method = RequestMethod.PUT)
	public ResponseEntity<RestResponse> updateSport(@PathVariable("id") Integer eventOrganizerId,
			@RequestBody EventOrg eventorg) {
		log.debug("updateSport() sportsId={}, sports={}", eventOrganizerId, eventorg);

		eventorg.setEventOrganizerId(eventOrganizerId);
		EventOrg sportsFromDatabase = eventorgservice.get(eventOrganizerId);
		if (Objects.isNull(sportsFromDatabase)) {
			log.error("Unable to update Sport with id {} not found.", eventOrganizerId);
			return ResponseEntity.notFound().build();
		}

		Integer updatedRows = eventorgservice.update(eventorg);
		log.debug("updateSport() >> sportsId={}, sports={}, updatedRows={}", eventOrganizerId, eventorg, updatedRows);

		return isNull(updatedRows) || updatedRows.intValue() != 1
				? new ResponseEntity<RestResponse>(new RestResponse(false, eventOrganizerId + " updated failed."),
						HttpStatus.BAD_REQUEST)
				: new ResponseEntity<RestResponse>(new RestResponse(true, eventOrganizerId + " updated successfully."),
						HttpStatus.ACCEPTED);
	}

	@RequestMapping(value = "/deleteEventOrganizer/{eventOrganizerId}", method = RequestMethod.DELETE)
	public ResponseEntity<RestResponse> deleteSport(@PathVariable("eventOrganizerId") Integer eventOrganizerId) {
		log.debug("deleteSport{} << sportId={}", eventOrganizerId);

		Integer deletedRows = eventorgservice.delete(eventOrganizerId);
		log.debug("deleteSport{} >> sportId={}, deletedRows={}", eventOrganizerId, deletedRows);

		return isNull(deletedRows) || deletedRows.intValue() != 1 ? new ResponseEntity<RestResponse>(
				new RestResponse(false, eventOrganizerId + " is invalid or incorrect data submitted."), HttpStatus.BAD_REQUEST)
				: new ResponseEntity<RestResponse>(new RestResponse(true, eventOrganizerId + " deleted successfully."),
						HttpStatus.ACCEPTED);

	}

}