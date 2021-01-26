package com.skiya.sportzplatform.mapper;

import com.skiya.sportzplatform.domain.Social;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SocialMapper {
    int deleteByPrimaryKey(Integer socialId);

    int insert(Social record);

    Social selectByPrimaryKey(Integer socialId);

    List<Social> selectAll();

    int updateByPrimaryKey(Social record);
}