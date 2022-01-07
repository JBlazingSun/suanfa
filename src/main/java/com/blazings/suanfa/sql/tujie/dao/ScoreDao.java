package com.blazings.suanfa.sql.tujie.dao;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;
import com.blazings.suanfa.sql.tujie.entity.Score;

/**
 * (Score)???????????
 *
 * @author makejava
 * @since 2022-01-07 15:13:24
 */
@Mapper
public interface ScoreDao extends BaseMapper<Score> {

	int insertBatch(@Param("entities") List<Score> entities);


	int insertOrUpdateBatch(@Param("entities") List<Score> entities);

}

