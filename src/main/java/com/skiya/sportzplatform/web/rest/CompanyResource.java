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

import com.skiya.sportzplatform.domain.Company;
import com.skiya.sportzplatform.domain.User;
import com.skiya.sportzplatform.dto.RestResponse;
import com.skiya.sportzplatform.service.CompanyService;
import com.skiya.sportzplatform.service.UserService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/company")
public class CompanyResource {
	
	private final Logger log = LoggerFactory.getLogger(CompanyResource.class);
	
	@Autowired
	private CompanyService companyService;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ResponseEntity<List<Company>> getAllCompanies() {
		List<Company> lookupList = companyService.getAll();
		if (Objects.isNull(lookupList)) {
			return new ResponseEntity<List<Company>>(HttpStatus.OK);
		}
		return new ResponseEntity<List<Company>>(lookupList, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getCompany(@PathVariable("id") Integer id) {
		log.debug("Company Id..." + id);
		Company company = companyService.getCompany(id);
		if (Objects.isNull(company)) {
			log.error("Company with type {} not found.", company);
			return new ResponseEntity<Object>(new RestResponse(false, "Company with type " + id + " not found"),
					HttpStatus.OK);
		}
		return new ResponseEntity<Company>(company, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/addCompany", method = RequestMethod.POST)
	public ResponseEntity<?> addCompany(@RequestBody Company company, HttpServletRequest request) {
		log.debug("Company Details..." + company.toString());
		Company companyDTO1 = companyService.getCompanyByEmail(company.getCompanyEmail());
		if(Objects.nonNull(companyDTO1)) {
			log.error("Company with same email addreess exist.", company.getCompanyEmail());
			return new ResponseEntity<Object>(new RestResponse(false,"Email Address "+ company.getCompanyEmail() + " already in use!"),
					HttpStatus.OK);
		}
		String appUrl = request.getScheme() + "://" + request.getServerName();
		log.debug("Test url..." + appUrl);
		User user = company.getUser();
		if(Objects.nonNull(user)) {
			log.error("Company Admin details empty");
			return new ResponseEntity<Object>(new RestResponse(false,"Company Admin details empty"),
					HttpStatus.OK);
		}
		userService.addUser(user);
		userService.sendActivationEmail(user, appUrl);
		company.setCompanyAdmin(user.getUserId());
		companyService.addCompany(company);
		return new ResponseEntity<Object>(new RestResponse(true,"Company with id " + company.getCompanyId() + " created successfully."),
				HttpStatus.OK);
    }
	
	@RequestMapping(value = "/updateCompany/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateCompany(@PathVariable("id") Integer companyId, 
			@RequestBody Company company) {
		log.debug("Updating Company for id " + companyId);
		company.setCompanyId(companyId);
		Company existingCompany = companyService.getCompany(companyId);
		if (Objects.isNull(existingCompany)) {
			log.error("Unable to update. Company with id {} not found.", companyId);
			return new ResponseEntity<Object>(new RestResponse(false,"Unable to update. Company with id " + companyId + " not found."),
					HttpStatus.OK);
		}
		companyService.updateCompany(company);
		return new ResponseEntity<Object>(new RestResponse(true,"Company with id " + companyId + " updated successfully."),
				HttpStatus.OK);
	}
	
	@RequestMapping(value = "/deleteCompany/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteCompany(@PathVariable("id") Integer companyId) {
		log.info("Fetching & Deleting Company with id {}", companyId);

		Company existingCompany = companyService.getCompany(companyId);
		if (Objects.isNull(existingCompany)) {
			log.error("Unable to delete. Company with id {} not found.", companyId);
			return new ResponseEntity<Object>(new RestResponse(false,"Unable to delete. Company with id " + companyId + " not found."),
					HttpStatus.OK);
		}
		companyService.deleteCompany(companyId);
		return new ResponseEntity<Object>(new RestResponse(true,"Company with id " + companyId + " deleted successfully."),
				HttpStatus.OK);
	}

}
