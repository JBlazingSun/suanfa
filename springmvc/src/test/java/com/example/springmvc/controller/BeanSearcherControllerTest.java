package com.example.springmvc.controller;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.date.TimeInterval;
import cn.hutool.core.util.NumberUtil;
import com.ejlchina.searcher.BeanSearcher;
import com.ejlchina.searcher.util.MapUtils;
import com.example.springmvc.entity.User;
import com.example.springmvc.entity.beansearcher.*;
import com.example.springmvc.entity.beansearcher.entity.course;
import com.example.springmvc.entity.beansearcher.entity.score;
import com.example.springmvc.entity.beansearcher.entity.student;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

//https://www.cnblogs.com/Diyo/p/11424844.html
@SpringBootTest
class BeanSearcherControllerTest {

	TimeInterval timer;

	@BeforeEach
	void setUp() {
		timer = DateUtil.timer();
	}

	@AfterEach
	void tearDown() {
		System.out.println("花费毫秒数 = " + timer.interval());
	}

	@Resource
	BeanSearcher searcher;

	//-- 14、查询没学过"张三"老师讲授的任一门课程的学生姓名
	@Test
	void name14() {
		Map<String, Object> build = MapUtils.builder()
			.onlySelect(student::getSName)
			.build();
		List<String> q14s = searcher.searchList(Q14.class, build).stream()
			.map(student::getSName)
			.collect(Collectors.toList());
	}

	//Q13
	//-- 13、查询和"01"号的同学学习的课程完全相同的其他同学的信息
	@Test
	void name13() {
		Map<String, Object> cid01 = MapUtils.builder()
			.onlySelect(score::getCId)
			.field(score::getSId, "01")
			.build();
		Set<String> cid01Set = searcher.searchList(score.class, cid01).stream()
			.map(score::getCId)
			.collect(Collectors.toSet());

		List<Q13> q13sWithOut01 = searcher.searchList(Q13.class, null);

		List<HashMap<@Nullable Object, @Nullable Object>> collect = q13sWithOut01.stream()
			.map(q13 -> {
				HashMap<@Nullable Object, @Nullable Object> map = Maps.newHashMap();
				HashSet<@Nullable Object> set = Sets.newHashSet();
				q13sWithOut01.stream().forEach(q131 -> {
					if (q131.getSId().equals(q13.getSId()))
						set.add(q131.getCid());
				});
				map.put(q13.getSId(), set);
				return map;
			})
			.collect(Collectors.toList());

		List<@Nullable Object> sameStuList = collect.stream()
			.flatMap(objectObjectHashMap -> objectObjectHashMap.entrySet().stream())
			.filter(objectObjectEntry -> {
				Sets.SetView<String> setView = Sets.difference(cid01Set, (Set<?>) objectObjectEntry.getValue());
				return setView.size() == 0;
			})
			.map(sameStu -> {
				HashSet<@Nullable Object> setStu = Sets.newHashSet();
				q13sWithOut01.forEach(q13 -> {
					if (q13.getSId().equals(sameStu.getKey())) {
						student stu = new student();
						BeanUtils.copyProperties(q13, stu);
						setStu.add(stu);
					}
				});
				return setStu;
			})
			.distinct()
			.flatMap(objects -> objects.stream())
			.collect(Collectors.toList());

		System.out.println("sameStuList = " + sameStuList);
	}

	//Q12
	//-- 12、查询至少有一门课与学号为"01"的同学所学相同的同学的信息
	@Test
	void name12() {
//		List<Q12> q12s = searcher.searchList(Q12.class, null);

		Set<Integer> sets = Sets.newHashSet(1, 2, 3, 4, 5, 6);
		Set<Integer> sets2 = Sets.newHashSet(1, 2, 3, 4);


		// 交集
		System.out.println("交集为：");
		Sets.SetView<Integer> intersection = Sets.intersection(sets, sets2);
		for (Integer temp : intersection) {
			System.out.println(temp);
		}
		// 差集
		System.out.println("差集为：");
		Sets.SetView<Integer> diff = Sets.difference(sets, sets2);
		System.out.println("diff.size() = " + diff.size());
		for (Integer temp : diff) {
			System.out.println(temp);
		}
		// 并集
		System.out.println("并集为：");
		Sets.SetView<Integer> union = Sets.union(sets, sets2);
		for (Integer temp : union) {
			System.out.println(temp);
		}

	}

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