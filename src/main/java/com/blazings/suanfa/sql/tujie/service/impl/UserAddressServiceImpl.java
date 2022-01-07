package com.blazings.suanfa.sql.tujie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.blazings.suanfa.sql.tujie.dao.UserAddressDao;
import com.blazings.suanfa.sql.tujie.entity.UserAddress;
import com.blazings.suanfa.sql.tujie.service.UserAddressService;
import org.springframework.stereotype.Service;

/**
 * (UserAddress)??????????
 *
 * @author makejava
 * @since 2022-01-07 15:26:25
 */
@Service("userAddressService")
public class UserAddressServiceImpl extends ServiceImpl<UserAddressDao, UserAddress> implements UserAddressService {

}

