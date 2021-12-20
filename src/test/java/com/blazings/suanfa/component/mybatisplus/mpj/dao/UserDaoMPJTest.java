package com.blazings.suanfa.component.mybatisplus.mpj.dao;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blazings.suanfa.component.mybatisplus.mpj.dto.UserDTO;
import com.blazings.suanfa.component.mybatisplus.mpj.entity.User;
import com.blazings.suanfa.component.mybatisplus.mpj.entity.UserAddress;
import com.github.yulichang.toolkit.MPJWrappers;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class UserDaoMPJTest {
	@Resource
	UserDao userDao;

	@BeforeEach
	void setUp() {
	}

	@AfterEach
	void tearDown() {
	}

	@Test
	void name() {
		Page<User> page = new Page<>(1, 10);
		MPJLambdaWrapper<User> userMPJLambdaWrapper = new MPJLambdaWrapper<User>()
			.selectAll(User.class)
			.leftJoin(UserAddress.class,UserAddress::getUserId, User::getId);
		Page<User> userPage = userDao.selectPage(page, userMPJLambdaWrapper);
	}

	@Test
	void name1() {
		MPJLambdaWrapper<UserDTO> er = new MPJLambdaWrapper<UserDTO>()
			.selectAll(User.class)
			.selectAll(UserAddress.class)
			.leftJoin(UserAddress.class,UserAddress::getUserId,User::getId)
			.eq(User::getId, 1);
		List<UserDTO> dtos = userDao.selectJoinList(UserDTO.class,er);
	}
}