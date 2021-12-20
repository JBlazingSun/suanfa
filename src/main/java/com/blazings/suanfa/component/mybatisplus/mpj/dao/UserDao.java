package com.blazings.suanfa.component.mybatisplus.mpj.dao;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.yulichang.base.MPJBaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;
import com.blazings.suanfa.component.mybatisplus.mpj.entity.User;

/**
 * (User)???????????
 *
 * @author makejava
 * @since 2021-12-20 15:24:53
 */
@Mapper
public interface UserDao extends MPJBaseMapper<User> {

	int insertBatch(@Param("entities") List<User> entities);


	int insertOrUpdateBatch(@Param("entities") List<User> entities);

}

