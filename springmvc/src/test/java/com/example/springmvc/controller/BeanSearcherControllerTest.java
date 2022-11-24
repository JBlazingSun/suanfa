package com.example.springmvc.controller;

import com.ejlchina.searcher.BeanSearcher;
import com.example.springmvc.entity.User;
import com.example.springmvc.entity.beansearcher.Q1;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

//https://www.cnblogs.com/Diyo/p/11424844.html
@SpringBootTest
class BeanSearcherControllerTest {

	@Resource
	BeanSearcher searcher;

	@Test
		//Q1
	void name() {
		List<Q1> q1s = searcher.searchList(Q1.class, null);
	}

	@Test
		//插入测试数据
	void index() {
		for (int i = 1; i < 50; i++) {
			User user = new User();
//			user.setId(0L);
			user.setName(String.valueOf(i));
			user.setAge(i);
			user.setPoint(i);

//			userMapper.insert(user);
		}
	}
}