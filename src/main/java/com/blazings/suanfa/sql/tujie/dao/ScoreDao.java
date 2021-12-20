package com.blazings.suanfa.sql.tujie.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.blazings.suanfa.sql.tujie.entity.Score;
import com.github.yulichang.base.MPJBaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Score)�����ݿ���ʲ�
 *
 * @author makejava
 * @since 2021-12-16 21:50:01
 */
@Mapper
public interface ScoreDao extends MPJBaseMapper<Score> {

	int insertBatch(@Param("entities") List<Score> entities);


	int insertOrUpdateBatch(@Param("entities") List<Score> entities);

	/**
	 * 查询所有学生的学号、姓名、选课数、总成绩
	 */

}

