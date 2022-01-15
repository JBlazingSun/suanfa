package com.blazings.suanfa.sql.sqlintroduction.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.blazings.suanfa.sql.sqlintroduction.dao.UserProfileDao;
import com.blazings.suanfa.sql.sqlintroduction.entity.UserProfile;
import com.blazings.suanfa.sql.sqlintroduction.service.UserProfileService;
import org.springframework.stereotype.Service;

/**
 * (UserProfile)表服务实现类
 *
 * @author makejava
 * @since 2022-01-15 16:57:51
 */
@Service("userProfileService")
public class UserProfileServiceImpl extends ServiceImpl<UserProfileDao, UserProfile> implements UserProfileService {

}

