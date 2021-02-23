package com.skiya.sportzplatform.service;

import java.util.List;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skiya.sportzplatform.domain.Sports;
import com.skiya.sportzplatform.domain.SportsCategory;
import com.skiya.sportzplatform.mapper.SportsMapper;

@Service
public class SportsService extends AbstractBaseService{
	
	private final Logger log = LoggerFactory.getLogger(SportsService.class);

	@Autowired
	SportsMapper sportsMapper;
	
	public Sports get(Integer sportsId) {
		Sports sport = sportsMapper.selectByPrimaryKey(sportsId);
		if(Objects.nonNull(sport)) {
			sport.setSportsFormat(toJson(sport.getSportsFormat().toString(), Object.class));
			sport.setSportsCategory(toJson(sport.getSportsCategory().toString(), Object.class));
		}
		return sport;
	}
	
	public Sports getByName(String sportsName) {
		Sports sport = sportsMapper.selectBySportsName(sportsName);
		if(Objects.nonNull(sport)) {
			sport.setSportsFormat(toJson(sport.getSportsFormat().toString(), Object.class));
			sport.setSportsCategory(toJson(sport.getSportsCategory().toString(), Object.class));
		}
		return sport;
	}
	
	public List<Sports> getAll() {
		List<Sports> sportList = sportsMapper.selectAll();
		if(Objects.nonNull(sportList)) {
			for(int a=0;a<sportList.size();a++) {
				Sports sport = sportList.get(a);
				if(Objects.nonNull(sport)) {
					sport.setSportsFormat(toJson(sport.getSportsFormat().toString(), Object.class));
					//sport.setSportsCategory(toJson(sport.getSportsCategory().toString(), Object.class));
				}
			}
		}
		return sportList;
	}
	
	public int create(Sports sport) {
		Objects.requireNonNull(sport, "Sports is mandatory to create");
		log.debug("Sport object..." + sport.toString());
		//sport.setSportsFormat(toJson(sport.getSportsFormat().toString(), Object.class));
		//sport.setSportsCategory(toJson(sport.getSportsCategory().toString(), Object.class));
		sportsMapper.insert(sport);
		System.out.println(sport);
		return sport.getSportsId();
	}
	
	public int update(Sports sport) {
		Objects.requireNonNull(sport, "Sports is mandatory to update");
		sport.setSportsFormat(toJson(sport.getSportsFormat().toString(), Object.class));
		//sport.setSportsCategory(toJson(sport.getSportsCategory().toString(), Object.class));
		return sportsMapper.updateByPrimaryKey(sport);
	}
	
	public int delete(Integer sportsId) {
		Objects.requireNonNull(sportsId, "Sports id is mandatory to delete");
		return sportsMapper.deleteByPrimaryKey(sportsId);
	}
	
}
