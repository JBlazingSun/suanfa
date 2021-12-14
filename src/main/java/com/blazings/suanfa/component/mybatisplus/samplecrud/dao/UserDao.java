package com.blazings.suanfa.component.mybatisplus.samplecrud.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.blazings.suanfa.component.mybatisplus.samplecrud.entity.User;
import org.apache.ibatis.annotations.Mapper;
/**
 * (User)表数据库访问层
 *
 * @author makejava
 * @since 2021-12-14 12:46:51
 */
@Mapper
public interface UserDao extends BaseMapper<User> {

}

