package com.blazings.suanfa.component.mybatisplus.mpj.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.blazings.suanfa.component.mybatisplus.mpj.dao.UserDao;
import com.blazings.suanfa.component.mybatisplus.mpj.entity.User;
import com.blazings.suanfa.component.mybatisplus.mpj.service.UserService;
import com.github.yulichang.base.MPJBaseServiceImpl;
import org.springframework.stereotype.Service;

/**
 * (User)??????????
 *
 * @author makejava
 * @since 2021-12-20 15:24:54
 */
@Service("userService")
public class UserServiceImpl extends MPJBaseServiceImpl<UserDao, User> implements UserService {

}

