package com.blazings.suanfa.component.mybatisplus.userpagination.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.blazings.suanfa.component.mybatisplus.userpagination.dao.UserPaginationDao;
import com.blazings.suanfa.component.mybatisplus.userpagination.entity.UserPagination;
import com.blazings.suanfa.component.mybatisplus.userpagination.service.UserPaginationService;
import org.springframework.stereotype.Service;

/**
 * (UserPagination)�����ʵ����
 *
 * @author makejava
 * @since 2021-12-16 20:11:57
 */
@Service("userPaginationService")
public class UserPaginationServiceImpl extends ServiceImpl<UserPaginationDao, UserPagination> implements UserPaginationService {

}

