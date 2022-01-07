package com.blazings.suanfa.sql.tujie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.blazings.suanfa.sql.tujie.dao.UserDao;
import com.blazings.suanfa.sql.tujie.entity.User;
import com.blazings.suanfa.sql.tujie.service.UserService;
import org.springframework.stereotype.Service;

/**
 * (User)??????????
 *
 * @author makejava
 * @since 2022-01-07 15:25:43
 */
@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {

}

