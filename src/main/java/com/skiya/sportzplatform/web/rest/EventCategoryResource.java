package com.skiya.sportzplatform.web.rest;

import static java.util.Objects.isNull;

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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.skiya.sportzplatform.domain.EventCategory;
import com.skiya.sportzplatform.domain.EventOrg;
import com.skiya.sportzplatform.domain.Sports;
import com.skiya.sportzplatform.domain.User;
import com.skiya.sportzplatform.dto.RestResponse;
import com.skiya.sportzplatform.service.EventCategoryService;
import com.skiya.sportzplatform.service.UserService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/eventcategory")
public class EventCategoryResource {

	private final Logger log = LoggerFactory.getLogger(EventCategoryResource.class);

	@Autowired
	private EventCategoryService eventcategoryservice;

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ResponseEntity<List<EventCategory>> getAllUsers() {
		List<EventCategory> lookupList = eventcategoryservice.getAll();
		if (lookupList.isEmpty()) {
			return new ResponseEntity<List<EventCategory>>(HttpStatus.OK);
		}
		return new ResponseEntity<List<EventCategory>>(lookupList, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getUser(@PathVariable("id") Integer id) {
		log.debug("User Id..." + id);
		EventCategory user = eventcategoryservice.get(id);
		if (Objects.isNull(user)) {
			log.error("User with type {} not found.", user);
			return new ResponseEntity<Object>(new RestResponse(false, "User with type " + id + " not found"),
					HttpStatus.OK);
		}
		return new ResponseEntity<EventCategory>(user, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/addEventOrganizer", method = RequestMethod.POST)
	public ResponseEntity<?> createSport(@RequestBody EventCategory eventorg) {
		log.debug("createSport() << sport={}", eventorg);
		//EventOrg eventorg1 = eventorgservice.getByName(sport.getSportsName());
		eventcategoryservice.create(eventorg);
		log.debug("createSport() >> sport={}, rowsAdded={}", eventorg);
		return Objects.nonNull(eventorg.getEventCategoryId()) 
				? new ResponseEntity<EventCategory>(eventorg, HttpStatus.CREATED)
				: new ResponseEntity<EventCategory>(HttpStatus.BAD_REQUEST);
	}
	
	
	@RequestMapping(value = "/updateEventCategory/{id}", method = RequestMethod.PUT)
	public ResponseEntity<RestResponse> updateSport(@PathVariable("id") Integer sportsId,
			@RequestBody EventCategory sport) {
		log.debug("EventCategory() sportsId={}, sports={}", sportsId, sport);

		sport.setEventCategoryId(sportsId);
		EventCategory sportsFromDatabase = eventcategoryservice.get(sportsId);
		if (Objects.isNull(sportsFromDatabase)) {
			log.error("Unable to update EventCategory with id {} not found.", sportsId);
			return ResponseEntity.notFound().build();
		}

		Integer updatedRows = eventcategoryservice.update(sport);
		log.debug("updateSport() >> sportsId={}, sports={}, updatedRows={}", sportsId, sport, updatedRows);

		return isNull(updatedRows) || updatedRows.intValue() != 1
				? new ResponseEntity<RestResponse>(new RestResponse(false, sportsId + " updated failed."),
						HttpStatus.BAD_REQUEST)
				: new ResponseEntity<RestResponse>(new RestResponse(true, sportsId + " updated successfully."),
						HttpStatus.ACCEPTED);
	}

	@RequestMapping(value = "/deleteEventCategory/{sportsId}", method = RequestMethod.DELETE)
	public ResponseEntity<RestResponse> deleteSport(@PathVariable("sportsId") Integer sportsId) {
		log.debug("deleteSport{} << sportId={}", sportsId);

		Integer deletedRows = eventcategoryservice.delete(sportsId);
		log.debug("deleteSport{} >> sportId={}, deletedRows={}", sportsId, deletedRows);

		return isNull(deletedRows) || deletedRows.intValue() != 1 ? new ResponseEntity<RestResponse>(
				new RestResponse(false, sportsId + " is invalid or incorrect data submitted."), HttpStatus.BAD_REQUEST)
				: new ResponseEntity<RestResponse>(new RestResponse(true, sportsId + " deleted successfully."),
						HttpStatus.ACCEPTED);

	}

}