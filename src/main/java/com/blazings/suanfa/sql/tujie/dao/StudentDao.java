package com.blazings.suanfa.sql.tujie.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.blazings.suanfa.sql.tujie.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Student)�����ݿ���ʲ�
 *
 * @author makejava
 * @since 2021-12-16 21:50:02
 */
@Mapper
public interface StudentDao extends BaseMapper<Student> {

	int insertBatch(@Param("entities") List<Student> entities);


	int insertOrUpdateBatch(@Param("entities") List<Student> entities);

}

