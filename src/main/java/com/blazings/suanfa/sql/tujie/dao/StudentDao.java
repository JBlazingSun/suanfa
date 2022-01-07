package com.blazings.suanfa.sql.tujie.dao;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;
import com.blazings.suanfa.sql.tujie.entity.Student;

/**
 * (Student)???????????
 *
 * @author makejava
 * @since 2022-01-07 15:13:25
 */
@Mapper
public interface StudentDao extends BaseMapper<Student> {

	int insertBatch(@Param("entities") List<Student> entities);


	int insertOrUpdateBatch(@Param("entities") List<Student> entities);

}

