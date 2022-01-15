package com.blazings.suanfa.sql.sqlintroduction.dao;

import com.blazings.suanfa.sql.sqlintroduction.entity.UserProfile;
import com.github.yulichang.base.MPJBaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (UserProfile)???????????
 *
 * @author makejava
 * @since 2022-01-13 10:45:48
 */
@Mapper
public interface UserProfileDao extends MPJBaseMapper<UserProfile> {

	int insertBatch(@Param("entities") List<UserProfile> entities);


	int insertOrUpdateBatch(@Param("entities") List<UserProfile> entities);

}

