package com.skiya.sportzplatform.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.skiya.sportzplatform.domain.Company;
import com.skiya.sportzplatform.domain.Organizer;
import com.skiya.sportzplatform.domain.User;
import com.skiya.sportzplatform.mapper.CompanyMapper;
import com.skiya.sportzplatform.mapper.OrganizerMapper;
import com.skiya.sportzplatform.mapper.UserMapper;

@Service
public class OrganizerService {
	
	@Autowired
	private OrganizerMapper organizerMapper;
	
	@Autowired
	private CompanyMapper companyMapper;
	
	@Autowired
	private UserMapper userMapper;
	
	public List<Organizer> getAll() {
		List<Company> companies = companyMapper.selectAllOrganizers();
		List<User> users = userMapper.selectAllOrganizers();
		List<Organizer> organizers = organizerMapper.selectAll();
		List<Organizer> organizersList = new ArrayList<Organizer>();
		for(int a =0;a<organizers.size();a++) {
			Organizer organizer = organizers.get(a);
			if(Objects.nonNull(organizer.getCompanyRefid())) {
				for(int b=0;b<companies.size();b++) {
					Company company = companies.get(b);
					if(organizer.getCompanyRefid().equals(company.getCompanyId())) {
						organizer = mapCompanyToOrganizer(company);
						organizersList.add(organizer);
					}
				}
				
			}
			if(Objects.nonNull(organizer.getUserRefid())) {
				for(int b=0;b<users.size();b++) {
					User user = users.get(b);
					if(organizer.getCompanyRefid().equals(user.getUserId())) {
						organizer = mapUserToOrganizer(user);
						organizersList.add(organizer);
					}
				}
			}
		}
		return organizersList;
    }
	
	public Organizer getOrganizer(Integer id) {
		Organizer organizer = organizerMapper.selectByPrimaryKey(Objects.requireNonNull(id, "Organizer id is missing"));
		if(Objects.nonNull(organizer)) {
			//Check for company first
			if(Objects.nonNull(organizer.getCompanyRefid()))
				organizer = mapCompanyToOrganizer(companyMapper.selectByPrimaryKey(organizer.getCompanyRefid()));
			if(Objects.nonNull(organizer.getUserRefid()))
				organizer = mapUserToOrganizer(userMapper.selectByPrimaryKey(organizer.getUserRefid()));
		}
		return organizer;
	}
	
	public Organizer getOrganizerByEmail(String email) {
		Organizer organizer = organizerMapper.selectEmail(Objects.requireNonNull(email, "Organizer id is missing"));
//		if(Objects.nonNull(organizer)) {
//			//Check for company first
//			if(Objects.nonNull(organizer.getCompanyRefid()))
//				organizer = mapCompanyToOrganizer(companyMapper.selectByPrimaryKey(organizer.getCompanyRefid()));
//			if(Objects.nonNull(organizer.getUserRefid()))
//				organizer = mapUserToOrganizer(userMapper.selectByPrimaryKey(organizer.getUserRefid()));
//		}
		return organizer;
	}
	
	@Transactional
	public int addOrganizer(Organizer organizer) {
		return organizerMapper.insert(Objects.requireNonNull(organizer, "Organizer object is empty"));
	}
	
	@Transactional
	public int updateOrganizer(Organizer organizer) {
		Objects.requireNonNull(organizer, "Organizer object is empty");
		Organizer organizer1 = organizerMapper.selectByPrimaryKey(organizer.getOrganizerId());
		Objects.requireNonNull(organizer1, "Organizer object doesnt exist in database");
		return organizerMapper.updateByPrimaryKey(organizer);
	}

	@Transactional
	public int deleteOrganizer(Integer id) {
		Objects.requireNonNull(id, "Organizer id is missing");
		Organizer organizer = organizerMapper.selectByPrimaryKey(id);
		Objects.requireNonNull(organizer, "Organizer object doesnt exist in database");
		return organizerMapper.deleteByPrimaryKey(id);
	}
	
	
	
	private Organizer mapUserToOrganizer(User user) {
		Organizer organizer = new Organizer();
		organizer.setOrganizerDesc(user.getUserDesc());
		organizer.setEmail(user.getUserEmail());
		organizer.setAlternateName(user.getAlternateName());
		organizer.setContact(user.getUserPhone());
		organizer.setWebsite(user.getUserWebsite());
		organizer.setProfileImg(user.getUserProfileImg());
		organizer.setOrganizerImg(user.getUserImg());
		organizer.setSocial(user.getSocial());
		organizer.setAddress(user.getAddress());
//		//Address mapping
//		if(Objects.nonNull(user.getAddress())) {
//			organizer.setAddress1(user.getAddress().getAddressLine1());
//			organizer.setAddress2(user.getAddress().getAddressLine2());
//			organizer.setAddress3(user.getAddress().getAddressLine3());
//			organizer.setPostalCode(user.getAddress().getPostalCode());
//			organizer.setCity(user.getAddress().getCity());
//			organizer.setState(user.getAddress().getState());
//			organizer.setCountry(user.getAddress().getCountry());
//			organizer.setLatitude(user.getAddress().getLatitude());
//			organizer.setLongtitude(user.getAddress().getLongtitude());
//		}
//		//Social Mapping
//		if(Objects.nonNull(user.getSocial())) {
//			organizer.setFacebookId(user.getSocial().getFacebookId());
//			organizer.setInstagramId(user.getSocial().getInstagramId());
//			organizer.setLinkedinId(user.getSocial().getLinkedinId());
//			organizer.setTwitterId(user.getSocial().getTwitterId());
//		}
		return organizer;
	}
	
	private Organizer mapCompanyToOrganizer(Company company) {
		Organizer organizer = new Organizer();
		organizer.setOrganizerDesc(company.getCompanyDesc());
		organizer.setEmail(company.getCompanyEmail());
		organizer.setAlternateName(company.getAlternateName());
		organizer.setContact(company.getCompanyContact());
		organizer.setWebsite(company.getCompanyWebsite());
		organizer.setProfileImg(company.getCompanyProfileImg());
		organizer.setOrganizerImg(company.getCompanyImg());
		organizer.setSocial(company.getSocial());
		organizer.setAddress(company.getAddress());
//		if(Objects.nonNull(company.getAddress())) {
//			organizer.setAddress1(company.getAddress().getAddressLine1());
//			organizer.setAddress2(company.getAddress().getAddressLine2());
//			organizer.setAddress3(company.getAddress().getAddressLine3());
//			organizer.setPostalCode(company.getAddress().getPostalCode());
//			organizer.setCity(company.getAddress().getCity());
//			organizer.setState(company.getAddress().getState());
//			organizer.setCountry(company.getAddress().getCountry());
//			organizer.setLatitude(company.getAddress().getLatitude());
//			organizer.setLongtitude(company.getAddress().getLongtitude());
//		}
//		//Social Mapping
//		if(Objects.nonNull(company.getSocial())) {
//			organizer.setFacebookId(company.getSocial().getFacebookId());
//			organizer.setInstagramId(company.getSocial().getInstagramId());
//			organizer.setLinkedinId(company.getSocial().getLinkedinId());
//			organizer.setTwitterId(company.getSocial().getTwitterId());
//		}
		return organizer;
	}
}