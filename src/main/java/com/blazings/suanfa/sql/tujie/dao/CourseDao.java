package com.blazings.suanfa.sql.tujie.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.blazings.suanfa.sql.tujie.entity.Course;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Course)�����ݿ���ʲ�
 *
 * @author makejava
 * @since 2021-12-16 21:50:01
 */
@Mapper
public interface CourseDao extends BaseMapper<Course> {

	int insertBatch(@Param("entities") List<Course> entities);


	int insertOrUpdateBatch(@Param("entities") List<Course> entities);

}

