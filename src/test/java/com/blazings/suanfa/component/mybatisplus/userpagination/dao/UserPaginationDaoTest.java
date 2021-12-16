package com.blazings.suanfa.component.mybatisplus.userpagination.dao;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blazings.suanfa.component.mybatisplus.userpagination.entity.UserPagination;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserPaginationDaoTest {
	@Autowired
	UserPaginationDao userPaginationDao;

	@BeforeEach
	void setUp() {
	}

	@AfterEach
	void tearDown() {
	}

	@Test
	void lambdaPagination() {
		Page<UserPagination> objectPage = new Page<>(1, 3);
		Page<UserPagination> userPaginationPage = userPaginationDao.selectPage(objectPage, new LambdaQueryWrapper<UserPagination>().eq(UserPagination::getAge, 20)
			.orderByAsc(UserPagination::getAge));
	}

	@Test
	void tests2() {
		UserPagination userPagination = new UserPagination();
		userPagination.setName("ss");
		userPagination.setAge(0);
		userPagination.setEmail("dd");
//		int insert = userPaginationDao.insert(userPagination);

	}

	@Test
	void insertBatch() {
	}

	@Test
	void insertOrUpdateBatch() {
	}
}