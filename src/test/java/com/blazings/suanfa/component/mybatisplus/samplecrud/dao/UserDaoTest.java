package com.blazings.suanfa.component.mybatisplus.samplecrud.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.blazings.suanfa.component.mybatisplus.samplecrud.entity.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class UserDaoTest {
	@Autowired
	UserDao userDao;

	@Resource
	User2Dao user2Dao;

	@BeforeEach
	void setUp() {
	}

	@AfterEach
	void tearDown() {
		userDao.delete(new QueryWrapper<User>().lambda().eq(User::getName, "小羊")
			.eq(User::getEmail, "abc@mp.com"));
	}

	@Test
	void aInsert() {
		User user = new User();
		user.setName("小羊");
		user.setAge(3);
		user.setEmail("abc@mp.com");
		assertThat(userDao.insert(user)).isGreaterThan(0);
		assertThat(user.getId()).isNotNull();
	}

}