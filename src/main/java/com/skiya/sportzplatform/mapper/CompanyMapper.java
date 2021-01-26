package com.skiya.sportzplatform.mapper;

import com.skiya.sportzplatform.domain.Company;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CompanyMapper {
    int deleteByPrimaryKey(Integer companyId);

    int insert(Company company);

    Company selectByPrimaryKey(Integer companyId);
    
    Company selectByEmail(String companyEmail);

    List<Company> selectAll();
    
    List<Company> selectAllOrganizers();

    int updateByPrimaryKey(Company company);
}