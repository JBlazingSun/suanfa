package com.example.springmvc.controller;

import com.ejlchina.searcher.BeanSearcher;
import com.example.springmvc.entity.User;
import com.example.springmvc.entity.beansearcher.Q1;
import com.example.springmvc.entity.beansearcher.Q3;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.stream.Collectors;

//https://www.cnblogs.com/Diyo/p/11424844.html
@SpringBootTest
class BeanSearcherControllerTest {

	@Resource
	BeanSearcher searcher;

	//Q3
	//3、查询平均成绩大于等于60分的同学的学生编号和学生姓名和平均成绩
	@Test
	void name3() {
//		Map<String, Object> build = MapUtils.builder()
//			.field(Q3::getStuName, "钱电")
//			.op(Operator.Equal)
//			.build();
		List<Q3> q3s = searcher.searchList(Q3.class, null);
		List<Q3> q3List = q3s.stream()
			.map(q3 -> {
				BigDecimal decimal = new BigDecimal(q3.getAvgScore());
				q3.setAvgScore(decimal.setScale(0, RoundingMode.HALF_UP).doubleValue());
				return q3;
			})
			.collect(Collectors.toList());
	}

	@Test
		//Q1
		//查询"01"课程比"02"课程成绩高的学生的信息及课程分数
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