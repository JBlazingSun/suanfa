package com.blazings.suanfa.sql.tujie.dao;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blazings.suanfa.sql.tujie.entity.User;
import com.blazings.suanfa.sql.tujie.entity.UserAddress;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class AreaDaoTest {

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

		MPJLambdaWrapper<User> join = new MPJLambdaWrapper<User>()
			.selectAll(User.class)
			.leftJoin(UserAddress.class,UserAddress::getUserId, User::getId)
			.eq(UserAddress::getUserId,User::getId);
		List<User> users = userDao.selectList(join);
	}

//	@Test
//	void name1() {
//		MPJLambdaWrapper<UserDTO> er = new MPJLambdaWrapper<UserDTO>()
//			.selectAll(User.class)
//			.selectAll(UserAddress.class)
//			.leftJoin(UserAddress.class,UserAddress::getUserId,User::getId)
//			.eq(User::getId, 1);
//		List<UserDTO> dtos = userDao.selectJoinList(UserDTO.class,er);
//	}
}