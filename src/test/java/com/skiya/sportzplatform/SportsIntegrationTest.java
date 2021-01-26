package com.skiya.sportzplatform;

import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.skiya.sportzplatform.domain.Sports;
import com.skiya.sportzplatform.dto.RestResponse;

public class SportsIntegrationTest {

	private static final Logger logger = LoggerFactory.getLogger(SportsIntegrationTest.class);

	private static final String uuId = UUID.randomUUID().toString().substring(0, 10);

	private static final RestTemplate restTemplate = new RestTemplateBuilder().build();

	@Test
	public void testGivenANewSportWhenInsertedThenSave() {
		// Create a sport
		Sports sport = new Sports();
		sport.setSportsDesc("Sport Desc ".concat(uuId));
		sport.setSportsName("Sport ".concat(uuId));

		ResponseEntity<Sports> sportsResponse = restTemplate.exchange("http://localhost:7777/sports", HttpMethod.POST,
				new HttpEntity<>(sport), new ParameterizedTypeReference<Sports>() {
				});
		final Sports newSport = sportsResponse.getBody();
		logger.info("New Sport {}", newSport);
		Assertions.assertEquals(HttpStatus.CREATED.value(), sportsResponse.getStatusCodeValue(), "Responses Match");
		Assertions.assertNotNull(sportsResponse.getBody().getSportsId(), "Responses Match");

		// Update Description
		final String updatedDesc = "Updated ".concat(newSport.getSportsDesc());
		newSport.setSportsDesc(updatedDesc);
		ResponseEntity<RestResponse> updateResponse = restTemplate.exchange(
				"http://localhost:7777/sports/" + newSport.getSportsId(), HttpMethod.PUT, new HttpEntity<>(newSport),
				new ParameterizedTypeReference<RestResponse>() {
				});
		Assertions.assertEquals(HttpStatus.ACCEPTED.value(), updateResponse.getStatusCodeValue(), "Responses Match");
		Assertions.assertEquals(true, updateResponse.getBody().getSuccess(), "Responses Match");
		// TODO: Add a scenario for false;

		// Get Sport
		ResponseEntity<Sports> sportInDB = restTemplate.exchange(
				"http://localhost:7777/sports/" + newSport.getSportsId(), HttpMethod.GET, null,
				new ParameterizedTypeReference<Sports>() {
				});
		Assertions.assertEquals(HttpStatus.ACCEPTED.value(), updateResponse.getStatusCodeValue(), "Responses Match");
		Assertions.assertEquals(updatedDesc, sportInDB.getBody().getSportsDesc(), "Responses Match");

		// Deleted Sport
		ResponseEntity<RestResponse> deletedSport = restTemplate.exchange(
				"http://localhost:7777/sports/" + newSport.getSportsId(), HttpMethod.DELETE, null,
				new ParameterizedTypeReference<RestResponse>() {
				});
		Assertions.assertEquals(HttpStatus.ACCEPTED.value(), deletedSport.getStatusCodeValue(), "Responses Match");
		Assertions.assertEquals(true, deletedSport.getBody().getSuccess(), "Responses Match");

		// Get Sport Again
		sportInDB = restTemplate.exchange("http://localhost:7777/sports/" + newSport.getSportsId(), HttpMethod.GET,
				null, new ParameterizedTypeReference<Sports>() {
				});
		logger.info("Sports from dataase {}", sportInDB);
		Assertions.assertEquals(HttpStatus.NOT_FOUND.value(), sportInDB.getStatusCodeValue(), "Responses Match");

	}

	@Test
	public void testGivenANewSportCategoryWhenInsertedThenSave() {
//		// Create a sport
//		Sports sport = new Sports();
//		sport.setSportsDesc("Tennis".concat(uuId));
//		sport.setSportsName("Tennis".concat(uuId));
//		ResponseEntity<Sports> sportsResponse = restTemplate.exchange("http://localhost:7777/sports", HttpMethod.POST,
//				new HttpEntity<>(sport), new ParameterizedTypeReference<Sports>() {
//				});
//		final Sports newSport = sportsResponse.getBody();
//		logger.info("New Sport {}", newSport);
//		Assertions.assertEquals(HttpStatus.CREATED.value(), sportsResponse.getStatusCodeValue(), "Responses Match");
//
//		// Create a new Category
//		SportsCategory sportsCategory = new SportsCategory();
//		//sportsCategory.setAgeRestriction("40");
//		//sportsCategory.setMaximumPlayers(2);
//		//sportsCategory.setMinimumPlayers(2);
//		sportsCategory.setParentCategoryId(null);
//		//sportsCategory.setSexRestriction("M");
//		sportsCategory.setSportsCategoryDesc("Male");
//		sportsCategory.setSportsCategoryName("Male Tennis");
//		//sportsCategory.setSportsCategoryType("123");
//		sportsCategory.setSportsRefid(newSport.getSportsId());
//		ResponseEntity<SportsCategory> sportsCategoryResponse = restTemplate.exchange(
//				"http://localhost:7777/sports-categories", HttpMethod.POST, new HttpEntity<>(sportsCategory),
//				new ParameterizedTypeReference<SportsCategory>() {
//				});
//		final SportsCategory newSportCategory = sportsCategoryResponse.getBody();
//		logger.info("New Sports Category {}", newSportCategory);
//		Assertions.assertEquals(HttpStatus.CREATED.value(), sportsCategoryResponse.getStatusCodeValue(),
//				"Responses Match");
//
//		// Update Sports Category
//		//sportsCategory.setAgeRestriction("35");
//		//sportsCategory.setMaximumPlayers(4);
//		ResponseEntity<RestResponse> updatedSportsCategoryResponse = restTemplate.exchange(
//				"http://localhost:7777/sports-categories/" + newSportCategory.getSportsCategoryId(), HttpMethod.PUT,
//				new HttpEntity<>(sportsCategory), new ParameterizedTypeReference<RestResponse>() {
//				});
//		logger.info("New Sport {}", updatedSportsCategoryResponse);
//		Assertions.assertEquals(HttpStatus.CREATED.value(), sportsResponse.getStatusCodeValue(), "Responses Match");
//		Assertions.assertEquals(true, updatedSportsCategoryResponse.getBody().getSuccess(), "Responses Match");
//
//		// Get Sports Category
//		ResponseEntity<SportsCategory> sportsCategoryInDB = restTemplate.exchange(
//				"http://localhost:7777/sports-categories/" + newSportCategory.getSportsCategoryId(), HttpMethod.GET,
//				null, new ParameterizedTypeReference<SportsCategory>() {
//				});
//		Assertions.assertEquals(HttpStatus.OK.value(), sportsCategoryInDB.getStatusCodeValue(), "Responses Match");
//		logger.info("Sports from dataase {}", sportsCategoryInDB);
//		//Assertions.assertEquals("35", sportsCategoryInDB.getBody().getAgeRestriction(), "Responses Match");
//
//		// Delete Sport Category
//		ResponseEntity<RestResponse> deletedSportCategory = restTemplate.exchange(
//				"http://localhost:7777/sports-categories/" + newSportCategory.getSportsCategoryId(), HttpMethod.DELETE,
//				null, new ParameterizedTypeReference<RestResponse>() {
//				});
//		Assertions.assertEquals(HttpStatus.ACCEPTED.value(), deletedSportCategory.getStatusCodeValue(),
//				"Responses Match");
//		Assertions.assertEquals(true, deletedSportCategory.getBody().getSuccess(), "Responses Match");
//
//		// Delete Sport
//		ResponseEntity<RestResponse> deletedSport = restTemplate.exchange(
//				"http://localhost:7777/sports/" + newSport.getSportsId(), HttpMethod.DELETE, null,
//				new ParameterizedTypeReference<RestResponse>() {
//				});
//		Assertions.assertEquals(HttpStatus.ACCEPTED.value(), deletedSport.getStatusCodeValue(), "Responses Match");
//		Assertions.assertEquals(true, deletedSport.getBody().getSuccess(), "Responses Match");
//
//		// Get Sport Again
//		sportsCategoryInDB = restTemplate.exchange(
//				"http://localhost:7777/sports-categories/" + sportsCategory.getSportsCategoryId(), HttpMethod.GET, null,
//				new ParameterizedTypeReference<SportsCategory>() {
//				});
//		logger.info("SportCategory from dataase {}", sportsCategoryInDB);
//		Assertions.assertEquals(HttpStatus.NOT_FOUND.value(), sportsCategoryInDB.getStatusCodeValue(),
//				"Responses Match");

	}

	@Test
	public void tesSportsGetAll() {
		RestTemplate restTemplate = new RestTemplateBuilder().build();
		ResponseEntity<List<Sports>> sportsResponse = restTemplate.exchange("http://localhost:7777/sports",
				HttpMethod.GET, null, new ParameterizedTypeReference<List<Sports>>() {
				});

		List<Sports> sports = sportsResponse.getBody();
		for (Sports sport : sports) {
			logger.info("Sports {}", sport);
		}
	}

}
