package com.example.springmvc.controller;

import com.ejlchina.searcher.BeanSearcher;
import com.ejlchina.searcher.SearchResult;
import com.ejlchina.searcher.util.MapUtils;
import com.example.springmvc.entity.User;
import com.example.springmvc.mapper.UserMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@SpringBootTest
class BeanSearcherControllerTest {

	@Resource
	UserMapper userMapper;

	@Resource
	BeanSearcher searcher;

	@BeforeEach
	void setUp() {
	}

	//不带参数时，默认查询 15 条数据（因为 默认分页大小为 15 ，可配置）:
	@Test
	void name1() {
		SearchResult<User> users = searcher.search(User.class, null);
		List<User> dataList = users.getDataList();
		Number totalCount = users.getTotalCount();

		List<User> users1 = searcher.searchList(User.class, null);
	}

	@Test
	void name2() {
		Map<String, Object> build = MapUtils.builder()
			.page(1, 20)
			.build();
		List<User> users = searcher.searchList(User.class, build);
	}
	//分页检索时，返回分页信息：


	@Test
	void name3() {

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

			userMapper.insert(user);
		}
	}
}