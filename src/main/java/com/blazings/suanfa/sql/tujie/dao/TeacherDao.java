package com.blazings.suanfa.sql.tujie.dao;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;
import com.blazings.suanfa.sql.tujie.entity.Teacher;

/**
 * (Teacher)???????????
 *
 * @author makejava
 * @since 2022-01-07 15:13:25
 */
@Mapper
public interface TeacherDao extends BaseMapper<Teacher> {

	int insertBatch(@Param("entities") List<Teacher> entities);


	int insertOrUpdateBatch(@Param("entities") List<Teacher> entities);

}

