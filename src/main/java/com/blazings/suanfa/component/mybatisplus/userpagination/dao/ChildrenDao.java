package com.blazings.suanfa.component.mybatisplus.userpagination.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.blazings.suanfa.component.mybatisplus.userpagination.entity.Children;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Children)�����ݿ���ʲ�
 *
 * @author makejava
 * @since 2021-12-16 20:12:15
 */
@Mapper
public interface ChildrenDao extends BaseMapper<Children> {

	int insertBatch(@Param("entities") List<Children> entities);


	int insertOrUpdateBatch(@Param("entities") List<Children> entities);

}

