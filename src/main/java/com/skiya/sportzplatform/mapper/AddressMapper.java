package com.skiya.sportzplatform.mapper;

import com.skiya.sportzplatform.domain.Address;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AddressMapper {
    int deleteByPrimaryKey(Integer addressId);

    int insert(Address record);

    Address selectByPrimaryKey(Integer addressId);

    List<Address> selectAll();

    int updateByPrimaryKey(Address record);
}