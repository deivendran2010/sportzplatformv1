package com.skiya.sportzplatform.beanmapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.skiya.sportzplatform.domain.User;

@Mapper(componentModel = "spring")
public interface UserBeanMapper {
	
	@BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
            nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
	void forEntityUpdate(User userDTO, @MappingTarget User user);
	
	
}
