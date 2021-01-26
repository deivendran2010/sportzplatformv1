package com.skiya.sportzplatform.mapper;

import com.skiya.sportzplatform.domain.LookupType;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LookupTypeMapper {
    int deleteByPrimaryKey(String lookupType);

    int insert(LookupType record);

    LookupType selectByPrimaryKey(String lookupType);

    List<LookupType> selectAll();

    int updateByPrimaryKey(LookupType record);
}