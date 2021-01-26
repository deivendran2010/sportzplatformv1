package com.skiya.sportzplatform.web.rest;

import java.util.Objects;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.skiya.sportzplatform.domain.User;
import com.skiya.sportzplatform.dto.AppAuthToken;
import com.skiya.sportzplatform.dto.LoginUser;
import com.skiya.sportzplatform.dto.RestResponse;
import com.skiya.sportzplatform.security.JWTTokenProvider;
import com.skiya.sportzplatform.service.UserService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/token")
public class AuthenticationResource {

	private final Logger log = LoggerFactory.getLogger(AuthenticationResource.class);

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JWTTokenProvider jwtTokenUtil;

	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/generate-token", method = RequestMethod.POST)
	public ResponseEntity<?> generateToken(@RequestBody LoginUser loginUser)  {
		log.debug("User Id..." + loginUser.getUserEmail());
		try {
		Authentication authentication  = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginUser.getUserEmail(), loginUser.getPassword()));
			if(!authentication.isAuthenticated()) {
				log.error("Unable to authenticate User with id ", loginUser.getUserEmail());
				return new ResponseEntity<Object>(new RestResponse(false,"Unable to authenticate User with id " + loginUser.getUserEmail()),
						HttpStatus.OK);
			}
		}catch(AuthenticationException exception) {
			log.error("Unable to authenticate User with id ", exception.getMessage());
			return new ResponseEntity<Object>(new RestResponse(false,"Unable to authenticate User with id " + loginUser.getUserEmail()),
					HttpStatus.OK);
		}
		final User user = userService.getUserByEmail(loginUser.getUserEmail());
		final String token = jwtTokenUtil.generateToken(user);
		
		return new ResponseEntity<AppAuthToken>(new AppAuthToken(token, user.getUserEmail()), HttpStatus.OK);
	}
	
	@RequestMapping(value="/passwordEmail", method=RequestMethod.POST)
	public ResponseEntity<?> passwordEmail(@RequestBody LoginUser loginUser, HttpServletRequest request) {
		String userEmail = loginUser.getUserEmail();
		log.debug("User Id..." + userEmail);
		String appUrl = request.getScheme() + "://" + request.getServerName();
		log.debug("User Id..." + userEmail);
		User user = userService.getUserByEmail(userEmail);
		if(user == null) {
			log.error("Unable to find user with email address ", userEmail);
			return new ResponseEntity<Object>(new RestResponse(false,"Unable to find user with email address " + userEmail),
					HttpStatus.OK);
		}
		userService.sendPasswordEmail(user,appUrl);
		return new ResponseEntity<Object>(new RestResponse(true,"Reset Password for user with email address " + userEmail + " sent successfully."),
				HttpStatus.OK);
	}
	
	@RequestMapping(value="/resetPassword", method=RequestMethod.POST)
	public ResponseEntity<?> resetPassword(@RequestBody LoginUser loginUser) {
		Objects.requireNonNull(loginUser,"Login User cant be empty");
		log.debug("Login User..." + loginUser.toString());
		User user = userService.getUserByToken(loginUser.getToken());
		if(Objects.isNull(user)) {
			log.error("Unable to find user with Reset Token ", loginUser.getToken());
			return new ResponseEntity<Object>(new RestResponse(false,"Unable to find user with email address " + loginUser.getToken()),
					HttpStatus.OK);
		}
		User user1 = new User();
		user1.setUserId(user.getUserId());
		user1.setUserPassword(loginUser.getPassword());
		user1.setResetToken(null);
		userService.updateToken(user1);
		return new ResponseEntity<Object>(new RestResponse(true,"Reset Password for user with email address " + user.getUserEmail() + " done successfully."),
				HttpStatus.OK);
	}
	
	@RequestMapping(value="/activateUser", method=RequestMethod.POST)
	public ResponseEntity<?> activateUser(@RequestBody LoginUser loginUser) {
		User user = userService.getUserByToken(loginUser.getToken());
		if(Objects.isNull(user)) {
			log.error("Unable to find user with Reset Token ", loginUser.getToken());
			return new ResponseEntity<Object>(new RestResponse(false,"Unable to find user with email address " + loginUser.getToken()),
					HttpStatus.OK);
		}
		User user1 = new User();
		user1.setUserId(user.getUserId());
		user1.setUserStatus("AC");
		user1.setResetToken(null);
		user1.setUserPassword(null);
		//user.setUserPassword(loginUser.getPassword());
		userService.updateToken(user1);
		return new ResponseEntity<Object>(new RestResponse(true,"Activate User with email address " + user.getUserEmail() + " done successfully."),
				HttpStatus.OK);
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public ResponseEntity<Void> logout() throws AuthenticationException {
		log.debug("Logout...");
		return new ResponseEntity<>(null, HttpStatus.OK);
	}

}
