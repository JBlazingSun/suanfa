package com.blazings.suanfa.sql.tujie.dao;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.blazings.suanfa.sql.tujie.entity.Teacher;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TeacherDaoTest {
	@Autowired
	TeacherDao teacherDao;

	/**
	 * 查询姓“孟”老师的个数
	 */
	@Test
	void name() {
		LambdaQueryWrapper<Teacher> likeRight = new LambdaQueryWrapper<Teacher>()
			.likeRight(Teacher::getName, "孟");
		Long selectCount = teacherDao.selectCount(likeRight);
		Assertions.assertEquals(selectCount, 1);
	}
}