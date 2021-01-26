package com.skiya.sportzplatform.service;

import java.util.List;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.skiya.sportzplatform.domain.Company;
import com.skiya.sportzplatform.mapper.CompanyMapper;

@Service
public class CompanyService extends AbstractBaseService{
	
	private final Logger log = LoggerFactory.getLogger(CompanyService.class);
	
	@Autowired
	private CompanyMapper companyMapper;
	
	public List<Company> getAll() {
		List<Company> companies = companyMapper.selectAll();
		if(Objects.nonNull(companies)) {
			for(int a=0;a<companies.size();a++) {
				Company company = companies.get(a);
				if(Objects.nonNull(company.getSocial()))
					company.setSocial(toJson(company.getSocial().toString(), Object.class));
				if(Objects.nonNull(company.getAddress()))
					company.setAddress(toJson(company.getAddress().toString(), Object.class));
			}
		}
		return companies;
    }
	
	public Company getCompany(Integer id) {
		Company company = companyMapper.selectByPrimaryKey(Objects.requireNonNull(id, "Company id is missing"));
		if(Objects.nonNull(company.getSocial()))
				company.setSocial(toJson(company.getSocial().toString(), Object.class));
		if(Objects.nonNull(company.getAddress()))
			company.setAddress(toJson(company.getAddress().toString(), Object.class));
		return company;
	}
	
	public Company getCompanyByEmail(String companyEmail) {
		Company company = companyMapper.selectByEmail(Objects.requireNonNull(companyEmail, "Company Email is missing"));
		if(Objects.nonNull(company)) {
			if(Objects.nonNull(company.getSocial()))
				company.setSocial(toJson(company.getSocial().toString(), Object.class));
			if(Objects.nonNull(company.getAddress()))
				company.setAddress(toJson(company.getAddress().toString(), Object.class));
		}
		return company;
	}
	
	@Transactional
	public int addCompany(Company company) {
		Objects.requireNonNull(company, "Company object is empty");
		log.debug("Company object..." + company.toString());
		if(Objects.nonNull(company.getSocial()))
			company.setSocial(toJson(company.getSocial().toString(), Object.class));
		if(Objects.nonNull(company.getAddress()))
			company.setAddress(toJson(company.getAddress().toString(), Object.class));
		companyMapper.insert(company);
		return company.getCompanyId();
	}
	
	@Transactional
	public int updateCompany(Company company) {
		Objects.requireNonNull(company, "Company object is empty");
		Company company1 = companyMapper.selectByPrimaryKey(company.getCompanyId());
		Objects.requireNonNull(company1, "Company object doesnt exist in database");
		if(Objects.nonNull(company.getSocial()))
			company.setSocial(toJson(company.getSocial().toString(), Object.class));
		if(Objects.nonNull(company.getAddress()))
			company.setAddress(toJson(company.getAddress().toString(), Object.class));
		return companyMapper.updateByPrimaryKey(company);
	}

	@Transactional
	public int deleteCompany(Integer id) {
		Objects.requireNonNull(id, "Company id is missing");
		Company company = companyMapper.selectByPrimaryKey(id);
		Objects.requireNonNull(company, "Company object doesnt exist in database");
		return companyMapper.deleteByPrimaryKey(id);
	}
}
