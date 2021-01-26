package com.skiya.sportzplatform.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skiya.sportzplatform.domain.Featured;
import com.skiya.sportzplatform.mapper.FeaturedMapper;

@Service
public class LandingService extends AbstractBaseService {

	private final Logger log = LoggerFactory.getLogger(LandingService.class);

	@Autowired
	private FeaturedMapper featuredMapper;

	public List<Featured> getHomepage() {
		List<Featured> featureds = new ArrayList<Featured>();
		featureds.addAll(featuredMapper.selectByType("CAROUSEL"));
		featureds.addAll(featuredMapper.selectByType("CARDS"));
		log.debug("Featured list Size..." + featureds.size());
		return featureds;
	}

}
