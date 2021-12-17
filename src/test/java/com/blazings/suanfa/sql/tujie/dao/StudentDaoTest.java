package com.blazings.suanfa.sql.tujie.dao;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.blazings.suanfa.sql.tujie.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class StudentDaoTest {
	@Autowired
	StudentDao studentDao;

	@Test
	void name() {
		LambdaQueryWrapper<Student> likeRight = new LambdaQueryWrapper<Student>()
			.likeRight(Student::getName, "猴");
		studentDao.selectList(likeRight).forEach(System.out::println);
	}
}