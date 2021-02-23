package com.skiya.sportzplatform.web.rest;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;

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
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.skiya.sportzplatform.domain.Events;
import com.skiya.sportzplatform.domain.User;
import com.skiya.sportzplatform.dto.RestResponse;
import com.skiya.sportzplatform.filestorage.FileStorageService;
import com.skiya.sportzplatform.service.UserService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/user")
public class UserResource {

	private final Logger log = LoggerFactory.getLogger(UserResource.class);

	@Autowired
	private UserService userService;

	@Autowired
	private FileStorageService fileStorageService;
	
	
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ResponseEntity<List<User>> getAllUsers() {
		List<User> lookupList = userService.getAll();
		if (lookupList.isEmpty()) {
			return new ResponseEntity<List<User>>(HttpStatus.OK);
		}
		return new ResponseEntity<List<User>>(lookupList, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getUser(@PathVariable("id") Integer id) {
		log.debug("User Id..." + id);
		User user = userService.getUser(id);
		if (Objects.isNull(user)) {
			log.error("User with type {} not found.", user);
			return new ResponseEntity<Object>(new RestResponse(false, "User with type " + id + " not found"),
					HttpStatus.OK);
		}
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/addUsers",method = RequestMethod.POST,
			consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE})
	public ResponseEntity<?> createSport(@RequestPart("jsondata") String jsondata, @RequestPart("file") MultipartFile file,@RequestPart("file2") MultipartFile file2,HttpServletRequest request) throws IOException  {
		
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
	        ObjectMapper h = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		User user =h.readerFor(User.class).readValue(jsondata);

		user.setUserProfileImg(fileDownloadUri);
		user.setUserImg(fileDownloadUri1);
		
		
		
		log.debug("User Details..." + user.toString());
		User userDTO1 = userService.getUserByEmail(user.getUserEmail());
		if(Objects.nonNull(userDTO1)) {
			log.error("User with same email addreess exist.", user.getUserEmail());
			return new ResponseEntity<Object>(new RestResponse(false,"Email Address "+ user.getUserEmail() + " already in use!"),
					HttpStatus.OK);
		}
		String appUrl = request.getScheme() + "://" + request.getServerName();
		log.debug("Test url..." + appUrl);
		userService.addUser(user);
		userService.sendActivationEmail(user, appUrl);
		
		
		return new ResponseEntity<Object>(new RestResponse(true,"User with id " + user.getUserId() + " created successfully."),
				HttpStatus.OK);
    }
	
	@RequestMapping(value = "/updateUser/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateUser(@PathVariable("id") Integer userId, 
			@RequestBody User user) {
		log.debug("Updating User for id " + userId);
		user.setUserId(userId);
		User existingUser = userService.getUser(userId);
		if (Objects.isNull(existingUser)) {
			log.error("Unable to update. User with id {} not found.", userId);
			return new ResponseEntity<Object>(new RestResponse(false,"Unable to update. User with id " + userId + " not found."),
					HttpStatus.OK);
		}
		userService.updateUser(user);
		return new ResponseEntity<Object>(new RestResponse(true,"User with id " + userId + " updated successfully."),
				HttpStatus.OK);
	}
	
	@RequestMapping(value = "/deleteUser/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteUser(@PathVariable("id") Integer userId) {
		log.info("Fetching & Deleting User with id {}", userId);

		User existingUser = userService.getUser(userId);
		if (Objects.isNull(existingUser)) {
			log.error("Unable to delete. User with id {} not found.", userId);
			return new ResponseEntity<Object>(new RestResponse(false,"Unable to delete. User with id " + userId + " not found."),
					HttpStatus.OK);
		}
		userService.deleteUser(userId);
		return new ResponseEntity<Object>(new RestResponse(true,"User with id " + userId + " deleted successfully."),
				HttpStatus.OK);
	}

}