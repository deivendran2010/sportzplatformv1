package com.skiya.sportzplatform.mapper;

import com.skiya.sportzplatform.domain.Featured;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FeaturedMapper {
    int deleteByPrimaryKey(Integer featuredId);

    int insert(Featured record);

    Featured selectByPrimaryKey(Integer featuredId);

    List<Featured> selectAll();
    
    List<Featured> selectByType(String featuredType);

    int updateByPrimaryKey(Featured record);
}