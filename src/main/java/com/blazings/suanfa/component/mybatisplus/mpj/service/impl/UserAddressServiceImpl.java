package com.blazings.suanfa.component.mybatisplus.mpj.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.blazings.suanfa.component.mybatisplus.mpj.dao.UserAddressDao;
import com.blazings.suanfa.component.mybatisplus.mpj.entity.UserAddress;
import com.blazings.suanfa.component.mybatisplus.mpj.service.UserAddressService;
import com.github.yulichang.base.MPJBaseServiceImpl;
import org.springframework.stereotype.Service;

/**
 * (UserAddress)??????????
 *
 * @author makejava
 * @since 2021-12-20 15:25:06
 */
@Service("userAddressService")
public class UserAddressServiceImpl extends MPJBaseServiceImpl<UserAddressDao, UserAddress> implements UserAddressService {

}

