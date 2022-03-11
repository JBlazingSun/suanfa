package com.example.mybatisplus.userpagination.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mybatisplus.userpagination.entity.UserPagination;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (UserPagination)�����ݿ���ʲ�
 *
 * @author makejava
 * @since 2021-12-16 20:11:57
 */
@Mapper
public interface UserPaginationDao extends BaseMapper<UserPagination> {

	int insertBatch(@Param("entities") List<UserPagination> entities);


	int insertOrUpdateBatch(@Param("entities") List<UserPagination> entities);

}

