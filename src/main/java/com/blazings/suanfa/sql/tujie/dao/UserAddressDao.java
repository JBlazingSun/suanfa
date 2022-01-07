package com.blazings.suanfa.sql.tujie.dao;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.yulichang.base.MPJBaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;
import com.blazings.suanfa.sql.tujie.entity.UserAddress;

/**
 * (UserAddress)???????????
 *
 * @author makejava
 * @since 2022-01-07 15:26:25
 */
@Mapper
public interface UserAddressDao extends MPJBaseMapper<UserAddress> {

	int insertBatch(@Param("entities") List<UserAddress> entities);


	int insertOrUpdateBatch(@Param("entities") List<UserAddress> entities);

}

