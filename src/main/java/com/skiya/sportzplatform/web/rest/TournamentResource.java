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

import com.skiya.sportzplatform.domain.Sports;
import com.skiya.sportzplatform.domain.TournamentCategories;
import com.skiya.sportzplatform.dto.RestResponse;
import com.skiya.sportzplatform.service.SportsService;
import com.skiya.sportzplatform.service.TournamentService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/newsports")
public class TournamentResource {

	private final Logger log = LoggerFactory.getLogger(TournamentResource.class);

	@Autowired
	private TournamentService sportsService;
	
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ResponseEntity<List<TournamentCategories>> getAllSports() {
		List<TournamentCategories> lookupList = sportsService.getAll();
		if (lookupList.isEmpty()) {
			return new ResponseEntity<List<TournamentCategories>>(HttpStatus.OK);
		}
		return new ResponseEntity<List<TournamentCategories>>(lookupList, HttpStatus.OK);
	}

/*	@RequestMapping(value = "/{sportsId}", method = RequestMethod.GET)
	public ResponseEntity<Sports> getSport(@PathVariable("sportsId") Integer sportsId) {
		log.debug("getSport() << sportsId={}", sportsId);

		TournamentCategories sports = sportsService.get(sportsId);
		log.debug("getSport() >> sportsId={}, sport={}", sportsId, sports);

		return Objects.nonNull(sports) && Objects.nonNull(sports.getTournamentCategoryId())
				? new ResponseEntity<TournamentCategories>(sports, HttpStatus.OK)
				: new ResponseEntity<TournamentCategories>(HttpStatus.OK);
	}*/
	
	@RequestMapping(value = "/addSport", method = RequestMethod.POST)
	public ResponseEntity<?> createSport(@RequestBody TournamentCategories sport) {
		log.debug("createSport() << sport={}", sport);
		/*Sports sport1 = sportsService.getByName(sport.getSportsName());
		if(Objects.nonNull(sport1)) {
			log.error("Sports with same name exist.", sport.getSportsName());
			return new ResponseEntity<Object>(new RestResponse(false,"Sports Name "+ sport.getSportsName() + " already exist!"),
					HttpStatus.OK);
		}
		*/
		sportsService.create(sport);
		log.debug("createSport() >> sport={}, rowsAdded={}", sport);
		return Objects.nonNull(sport.getTournamentCategoryId()) 
				? new ResponseEntity<TournamentCategories>(sport, HttpStatus.CREATED)
				: new ResponseEntity<TournamentCategories>(HttpStatus.BAD_REQUEST);
		
		 
		

	}
	@RequestMapping(value = "/updateSport/{id}", method = RequestMethod.PUT)
	public ResponseEntity<RestResponse> updateSport(@PathVariable("id") Integer sportsId,
			@RequestBody TournamentCategories sport) {
		log.debug("updateSport() sportsId={}, sports={}", sportsId, sport);

		sport.setTournamentCategoryId(sportsId);
		TournamentCategories sportsFromDatabase = sportsService.get(sportsId);
		if (Objects.isNull(sportsFromDatabase)) {
			log.error("Unable to update Sport with id {} not found.", sportsId);
			return ResponseEntity.notFound().build();
		}

		Integer updatedRows = sportsService.update(sport);
		log.debug("updateSport() >> sportsId={}, sports={}, updatedRows={}", sportsId, sport, updatedRows);

		return isNull(updatedRows) || updatedRows.intValue() != 1
				? new ResponseEntity<RestResponse>(new RestResponse(false, sportsId + " updated failed."),
						HttpStatus.BAD_REQUEST)
				: new ResponseEntity<RestResponse>(new RestResponse(true, sportsId + " updated successfully."),
						HttpStatus.ACCEPTED);
	}

	@RequestMapping(value = "/deleteSport/{sportsId}", method = RequestMethod.DELETE)
	public ResponseEntity<RestResponse> deleteSport(@PathVariable("sportsId") Integer sportsId) {
		log.debug("deleteSport{} << sportId={}", sportsId);

		Integer deletedRows = sportsService.delete(sportsId);
		log.debug("deleteSport{} >> sportId={}, deletedRows={}", sportsId, deletedRows);

		return isNull(deletedRows) || deletedRows.intValue() != 1 ? new ResponseEntity<RestResponse>(
				new RestResponse(false, sportsId + " is invalid or incorrect data submitted."), HttpStatus.BAD_REQUEST)
				: new ResponseEntity<RestResponse>(new RestResponse(true, sportsId + " deleted successfully."),
						HttpStatus.ACCEPTED);

	}
}