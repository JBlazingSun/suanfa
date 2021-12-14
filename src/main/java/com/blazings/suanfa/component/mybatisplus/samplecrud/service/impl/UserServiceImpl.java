package com.blazings.suanfa.component.mybatisplus.samplecrud.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.blazings.suanfa.component.mybatisplus.samplecrud.dao.UserDao;
import com.blazings.suanfa.component.mybatisplus.samplecrud.entity.User;
import com.blazings.suanfa.component.mybatisplus.samplecrud.service.UserService;
import org.springframework.stereotype.Service;

/**
 * (User)表服务实现类
 *
 * @author makejava
 * @since 2021-12-14 10:50:09
 */
@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {

}

