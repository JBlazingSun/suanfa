package com.blazings.suanfa.sql.tujie.dao;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.yulichang.base.MPJBaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;
import com.blazings.suanfa.sql.tujie.entity.User;

/**
 * (User)???????????
 *
 * @author makejava
 * @since 2022-01-07 15:25:42
 */
@Mapper
public interface UserDao extends MPJBaseMapper<User> {

	int insertBatch(@Param("entities") List<User> entities);


	int insertOrUpdateBatch(@Param("entities") List<User> entities);

}

