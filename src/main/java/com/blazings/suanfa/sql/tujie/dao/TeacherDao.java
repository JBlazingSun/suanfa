package com.blazings.suanfa.sql.tujie.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.blazings.suanfa.sql.tujie.entity.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Teacher)�����ݿ���ʲ�
 *
 * @author makejava
 * @since 2021-12-16 21:50:02
 */
@Mapper
public interface TeacherDao extends BaseMapper<Teacher> {

	int insertBatch(@Param("entities") List<Teacher> entities);


	int insertOrUpdateBatch(@Param("entities") List<Teacher> entities);

}

