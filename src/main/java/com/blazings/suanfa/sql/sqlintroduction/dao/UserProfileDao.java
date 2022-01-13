package com.blazings.suanfa.sql.sqlintroduction.dao;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;
import com.blazings.suanfa.sql.sqlintroduction.entity.UserProfile;

/**
 * (UserProfile)???????????
 *
 * @author makejava
 * @since 2022-01-13 10:45:48
 */
@Mapper
public interface UserProfileDao extends BaseMapper<UserProfile> {

	int insertBatch(@Param("entities") List<UserProfile> entities);


	int insertOrUpdateBatch(@Param("entities") List<UserProfile> entities);

}

