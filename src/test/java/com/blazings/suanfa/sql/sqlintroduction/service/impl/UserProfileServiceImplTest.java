package com.blazings.suanfa.sql.sqlintroduction.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.blazings.suanfa.sql.sqlintroduction.entity.UserProfile;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class UserProfileServiceImplTest {

	@Autowired
	UserProfileServiceImpl service;

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
}