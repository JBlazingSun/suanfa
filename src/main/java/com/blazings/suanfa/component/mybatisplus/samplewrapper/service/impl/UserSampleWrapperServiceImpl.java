package com.blazings.suanfa.component.mybatisplus.samplewrapper.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.blazings.suanfa.component.mybatisplus.samplewrapper.dao.UserSampleWrapperDao;
import com.blazings.suanfa.component.mybatisplus.samplewrapper.entity.UserSampleWrapper;
import com.blazings.suanfa.component.mybatisplus.samplewrapper.service.UserSampleWrapperService;
import org.springframework.stereotype.Service;

/**
 * (UserSampleWrapper)�����ʵ����
 *
 * @author makejava
 * @since 2021-12-16 15:34:01
 */
@Service("userSampleWrapperService")
public class UserSampleWrapperServiceImpl extends ServiceImpl<UserSampleWrapperDao, UserSampleWrapper> implements UserSampleWrapperService {

}

