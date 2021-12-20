package com.blazings.suanfa.component.mybatisplus.mpj.dao;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.yulichang.base.MPJBaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;
import com.blazings.suanfa.component.mybatisplus.mpj.entity.UserAddress;

/**
 * (UserAddress)???????????
 *
 * @author makejava
 * @since 2021-12-20 15:25:05
 */
@Mapper
public interface UserAddressDao extends MPJBaseMapper<UserAddress> {

	int insertBatch(@Param("entities") List<UserAddress> entities);


	int insertOrUpdateBatch(@Param("entities") List<UserAddress> entities);

}

