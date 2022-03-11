package com.example.mybatisplus.samplewrapper.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mybatisplus.samplewrapper.dao.UserRoleDao;
import com.example.mybatisplus.samplewrapper.entity.UserRole;
import com.example.mybatisplus.samplewrapper.service.UserRoleService;
import org.springframework.stereotype.Service;

/**
 * (UserRole)�����ʵ����
 *
 * @author makejava
 * @since 2021-12-16 16:14:11
 */
@Service("userRoleService")
public class UserRoleServiceImpl extends ServiceImpl<UserRoleDao, UserRole> implements UserRoleService {

}

