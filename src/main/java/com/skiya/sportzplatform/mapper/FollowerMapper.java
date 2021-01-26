package com.skiya.sportzplatform.mapper;

import com.skiya.sportzplatform.domain.Follower;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FollowerMapper {
    int deleteByPrimaryKey(Integer followerId);

    int insert(Follower record);

    Follower selectByPrimaryKey(Integer followerId);

    List<Follower> selectAll();

    int updateByPrimaryKey(Follower record);
}