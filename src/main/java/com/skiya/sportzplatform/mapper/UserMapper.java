package com.skiya.sportzplatform.mapper;

import com.skiya.sportzplatform.domain.User;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    User selectByPrimaryKey(Integer userId);
    
    User selectByEmail(String userEmail);
    
    User selectByResetToken(String resetToken);

    List<User> selectAll();
    
    List<User> selectAllOrganizers();

    int updateByPrimaryKey(User record);
    
}