package com.blazings.suanfa.component.mybatisplus.samplecrud.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.blazings.suanfa.component.mybatisplus.samplecrud.dao.User2Dao;
import com.blazings.suanfa.component.mybatisplus.samplecrud.entity.User2;
import com.blazings.suanfa.component.mybatisplus.samplecrud.service.User2Service;
import org.springframework.stereotype.Service;

/**
 * (User2)表服务实现类
 *
 * @author makejava
 * @since 2021-12-14 11:21:47
 */
@Service("user2Service")
public class User2ServiceImpl extends ServiceImpl<User2Dao, User2> implements User2Service {

}

