package com.blazings.suanfa.component.mybatisplus.mpj.dao;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.yulichang.base.MPJBaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;
import com.blazings.suanfa.component.mybatisplus.mpj.entity.Area;

/**
 * (Area)???????????
 *
 * @author makejava
 * @since 2021-12-20 15:24:35
 */
@Mapper
public interface AreaDao extends MPJBaseMapper<Area> {

	int insertBatch(@Param("entities") List<Area> entities);


	int insertOrUpdateBatch(@Param("entities") List<Area> entities);

}

