package com.skiya.sportzplatform.web.rest;

import static java.util.Objects.isNull;
//import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

//import com.bazlur.json.Program;
//import com.bazlur.json.ProgramDeserializer;
//import com.bazlur.json.SimpleModule;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.skiya.sportzplatform.domain.Community;
import com.skiya.sportzplatform.domain.Events;
import com.skiya.sportzplatform.domain.Sports;
//import com.skiya.sportzplatform.domain.Sports;
import com.fasterxml.jackson.databind.module.SimpleModule;

import com.skiya.sportzplatform.dto.RestResponse;
import com.skiya.sportzplatform.filestorage.FileStorageService;
import com.skiya.sportzplatform.service.EventsService;
//import com.skiya.sportzplatform.service.SportsService;

//import net.javaguides.springboot.fileuploaddownload.service.FileStorageService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/events")
public class EventsResource {

	private final Logger log = LoggerFactory.getLogger(EventsResource.class);
	
	@Autowired
	private EventsService eventsservice;
	
	@Autowired
	 private FileStorageService fileStorageService;
	 
	 ObjectMapper h = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		       
	
	
	
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ResponseEntity<List<Events>> getAllSports() {
		List<Events> lookupList = eventsservice.getAll();
		if (lookupList.isEmpty()) {
			return new ResponseEntity<List<Events>>(HttpStatus.OK);
		}
		return new ResponseEntity<List<Events>>(lookupList, HttpStatus.OK);
	}

	@RequestMapping(value = "/{eventId}", method = RequestMethod.GET)
	public ResponseEntity<Events> getSport(@PathVariable("eventId") Integer eventId) {
		log.debug("getSport() << sportsId={}", eventId);

		Events sports = eventsservice.get(eventId);
		log.debug("getSport() >> sportsId={}, sport={}", eventId, sports);

		return Objects.nonNull(sports) && Objects.nonNull(sports.getEventId())
				? new ResponseEntity<Events>(sports, HttpStatus.OK)
				: new ResponseEntity<Events>(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/addEvents",method = RequestMethod.POST,
			consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE})
	public ResponseEntity<?> createSport(@RequestPart("jsondata") String jsondata, @RequestPart("file") MultipartFile file,@RequestPart("file2") MultipartFile file2) throws IOException  {
		
		//log.debug("createSport() << sport={}", events);
		/*Events sport1 = eventsservice.getByName(events.getEventName());
		if(Objects.nonNull(sport1)) {
			log.error("Sports with same name exist.", events.getEventName());
			return new ResponseEntity<Object>(new RestResponse(false,"Sports Name "+ events.getEventName() + " already exist!"),
					HttpStatus.OK);
		}
		*/
		
		 String fileName = fileStorageService.storeFile(file);
		 String filename2=fileStorageService.storeFile(file2);

	        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
	                .path("/downloadFile/")
	                .path(fileName)
	                .toUriString();
	        String fileDownloadUri1 = ServletUriComponentsBuilder.fromCurrentContextPath()
	                .path("/downloadFile/")
	                .path(filename2)
	                .toUriString();
		Events readValue =h.readerFor(Events.class).readValue(jsondata);

	
		
		readValue.setEventFlyer(fileDownloadUri);
		readValue.setEventLogo(fileDownloadUri1);
		
		eventsservice.create(readValue);
		//}
		//log.debug("createSport() >> sport={}, rowsAdded={}", events);
		return Objects.nonNull(readValue.getEventId()) 
				? new ResponseEntity<Events>(readValue, HttpStatus.CREATED)
				: new ResponseEntity<Events>(HttpStatus.BAD_REQUEST);
		

	}
	
	@RequestMapping(value = "/updateEvent/{id}", method = RequestMethod.PUT)
	public ResponseEntity<RestResponse> updateSport(@PathVariable("id") Integer eventId,
			@RequestBody Events events) {
		log.debug("updateSport() sportsId={}, sports={}", eventId, events);

		events.setEventId(eventId);;
		Events sportsFromDatabase = eventsservice.get(eventId);
		if (Objects.isNull(sportsFromDatabase)) {
			log.error("Unable to update Sport with id {} not found.", eventId);
			return ResponseEntity.notFound().build();
		}

		Integer updatedRows = eventsservice.update(events);
		log.debug("updateSport() >> sportsId={}, sports={}, updatedRows={}", eventId, events, updatedRows);

		return isNull(updatedRows) || updatedRows.intValue() != 1
				? new ResponseEntity<RestResponse>(new RestResponse(false, eventId + " updated failed."),
						HttpStatus.BAD_REQUEST)
				: new ResponseEntity<RestResponse>(new RestResponse(true, eventId + " updated successfully."),
						HttpStatus.ACCEPTED);
	}

	@RequestMapping(value = "/deleteEvent/{eventId}", method = RequestMethod.DELETE)
	public ResponseEntity<RestResponse> deleteSport(@PathVariable("eventId") Integer eventId) {
		log.debug("deleteSport{} << sportId={}", eventId);

		Integer deletedRows = eventsservice.delete(eventId);
		log.debug("deleteSport{} >> sportId={}, deletedRows={}", eventId, deletedRows);

		return isNull(deletedRows) || deletedRows.intValue() != 1 ? new ResponseEntity<RestResponse>(
				new RestResponse(false, eventId + " is invalid or incorrect data submitted."), HttpStatus.BAD_REQUEST)
				: new ResponseEntity<RestResponse>(new RestResponse(true, eventId + " deleted successfully."),
						HttpStatus.ACCEPTED);

	}

	
	
	
	
}