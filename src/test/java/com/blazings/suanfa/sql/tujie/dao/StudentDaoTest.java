package com.blazings.suanfa.sql.tujie.dao;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.blazings.suanfa.sql.tujie.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;
@SpringBootTest
class StudentDaoTest {
	@Autowired
	StudentDao studentDao;
	/**
	 * 查询同名同姓学生名单并统计同名人数
	 */
	@Test
	void name5() {
		QueryWrapper<Student> name = new QueryWrapper<Student>()
			.select("name,COUNT(*) as sameName")
			.groupBy("name")
			.having("COUNT(`name`=`name`)>1");
		List<Map<String, Object>> students = studentDao.selectMaps(name);
	}

	/**
	 * 查询男生、女生人数
	 */
	@Test
	void name4() {
		QueryWrapper<Student> studentQueryWrapper = new QueryWrapper<Student>()
			.select("gender,COUNT(*)")
			.groupBy("gender");
		List<Map<String, Object>> selectMaps = studentDao.selectMaps(studentQueryWrapper);

	}
	@Test
	void name() {
		LambdaQueryWrapper<Student> likeRight = new LambdaQueryWrapper<Student>()
			.likeRight(Student::getName, "猴");
		studentDao.selectList(likeRight).forEach(System.out::println);
	}
}