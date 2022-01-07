package com.blazings.suanfa.sql.tujie.dao;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;
import com.blazings.suanfa.sql.tujie.entity.Course;

/**
 * (Course)???????????
 *
 * @author makejava
 * @since 2022-01-07 15:13:23
 */
@Mapper
public interface CourseDao extends BaseMapper<Course> {

	int insertBatch(@Param("entities") List<Course> entities);


	int insertOrUpdateBatch(@Param("entities") List<Course> entities);

}

