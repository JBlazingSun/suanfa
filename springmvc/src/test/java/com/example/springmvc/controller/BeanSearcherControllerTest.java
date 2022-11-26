package com.example.springmvc.controller;

import cn.hutool.core.util.NumberUtil;
import com.ejlchina.searcher.BeanSearcher;
import com.ejlchina.searcher.util.MapUtils;
import com.example.springmvc.entity.User;
import com.example.springmvc.entity.beansearcher.*;
import com.example.springmvc.entity.beansearcher.entity.course;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//https://www.cnblogs.com/Diyo/p/11424844.html
@SpringBootTest
class BeanSearcherControllerTest {

	@Resource
	BeanSearcher searcher;
	//q11
	//-- 11、查询没有学全所有课程的同学的信息


	@Test
	void name11() {
		Number courseNumber = searcher.searchCount(course.class, null);
		Map<String, Object> number = MapUtils.builder()
			.put("courseNumber", courseNumber)
			.build();
		List<Q11> q11s = searcher.searchList(Q11.class, number);
	}

	//Q9
	//-- 9、查询学过编号为"01"并且也学过编号为"02"的课程的同学的信息
	@Test
	void name9() {
		List<Q9> q9s = searcher.searchList(Q9.class, null);
	}

	//Q7
	//-- 7、查询学过"张三"老师授课的同学的信息
	@Test
	void name7() {
		List<Q7> q7s = searcher.searchList(Q7.class, null);
	}

	//Q6
	//-- 6、查询"李"姓老师的数量
	@Test
	void name6() {
		for (Q6 q6 : searcher.searchList(Q6.class, null)) {
			System.out.println("q6 = " + q6);
		}
	}

	//Q5
	//#--5、查询所有同学的学生编号、学生姓名、选课总数、所有课程的总成绩
	@Test
	void name5() {
		List<Q5> q5s = searcher.searchList(Q5.class, null);
	}

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
				q3.setAvgScore(NumberUtil.round(q3.getAvgScore(), 0));
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