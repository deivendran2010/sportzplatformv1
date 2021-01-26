package com.skiya.sportzplatform.mapper;

import com.skiya.sportzplatform.domain.LookupTable;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface LookupTableMapper {
    int deleteByPrimaryKey(@Param("lookupType") String lookupType, @Param("lookupKey") String lookupKey);

    int insert(LookupTable record);

    LookupTable selectByPrimaryKey(@Param("lookupType") String lookupType, @Param("lookupKey") String lookupKey);

    List<LookupTable> selectAll();

    int updateByPrimaryKey(LookupTable record);
}