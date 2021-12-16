package com.blazings.suanfa.sql.tujie.entity;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.blazings.suanfa.sql.tujie.dao.StudentDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class StudentTest {
	@Autowired
	StudentDao studentDao;

	@Test
	void name() {
		LambdaQueryWrapper<Student> likeRight = new LambdaQueryWrapper<Student>()
			.likeRight(Student::getName, "猴");
		studentDao.selectList(likeRight).forEach(System.out::println);
	}
}