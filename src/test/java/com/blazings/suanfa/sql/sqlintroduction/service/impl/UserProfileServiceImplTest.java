package com.blazings.suanfa.sql.sqlintroduction.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.blazings.suanfa.sql.sqlintroduction.entity.UserProfile;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

@SpringBootTest
class UserProfileServiceImplTest {

	@Autowired
	UserProfileServiceImpl service;

	@Test
	void name2() {

	}

	/**
	 * SQL3 查询结果去重
	 */
	@Test
	void name() {
		QueryWrapper<UserProfile> wrapper = new QueryWrapper<>();
		wrapper.select("DISTINCT university")
			.lambda();
		List<UserProfile> list = service.list(wrapper);
	}

	/**
	 * SQL4 查询结果限制返回行数
	 * 现在运营只需要查看前2个用户明细设备ID数据，请你从用户信息表 user_profile 中取出相应结果
	 */
	@Test
	void name1() {
		LambdaQueryWrapper<UserProfile> queryWrapper = new LambdaQueryWrapper<>();
		LambdaQueryWrapper<UserProfile> wrapper = queryWrapper.select(UserProfile::getDeviceId)
			.last("limit 2");
		List<Map<String, Object>> list = service.listMaps(wrapper);
	}
}