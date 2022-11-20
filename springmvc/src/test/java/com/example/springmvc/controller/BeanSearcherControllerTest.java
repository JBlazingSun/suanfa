package com.example.springmvc.controller;

import com.example.springmvc.entity.User;
import com.example.springmvc.mapper.UserMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class BeanSearcherControllerTest {

	@Resource
	UserMapper userMapper;

	@BeforeEach
	void setUp() {
	}

	@Test
		//插入测试数据
	void index() {
		for (int i = 31; i < 100; i++) {
			User user = new User();
			user.setName(String.valueOf(i));
			user.setAge(i);
//			userMapper.insert(user);
		}
	}
}