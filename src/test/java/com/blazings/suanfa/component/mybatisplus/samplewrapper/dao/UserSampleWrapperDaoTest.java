package com.blazings.suanfa.component.mybatisplus.samplewrapper.dao;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.blazings.suanfa.component.mybatisplus.samplewrapper.entity.UserSampleWrapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class UserSampleWrapperDaoTest {
	@Autowired
	UserSampleWrapperDao userSampleWrapperDao;
	@Autowired
	UserRoleDao roleDao;

	@BeforeEach
	void setUp() {
	}

	@AfterEach
	void tearDown() {
	}

	/**
	 * SELECT id,name FROM user
	 * WHERE (age BETWEEN ? AND ?) ORDER BY role_id ASC,id ASC
	 * WHERE (age BETWEEN ? AND ?) ORDER BY role_id ASC,id ASC
	 */
	@Test
	void testSelect() {
		LambdaQueryWrapper<UserSampleWrapper> order = new LambdaQueryWrapper<UserSampleWrapper>()
			.select(UserSampleWrapper::getId, UserSampleWrapper::getName)
			.between(UserSampleWrapper::getAge, 20, 25)
			.orderByAsc(UserSampleWrapper::getRoleId)
			.orderByAsc(UserSampleWrapper::getId);
		for (UserSampleWrapper userSampleWrapper : userSampleWrapperDao.selectList(order)) {
			System.out.println(userSampleWrapper);
		}

	}

	/**
	 * SELECT id,name,age,email,role_id FROM user
	 * WHERE ((name = ? AND age = ?) OR(name = ? AND age = ?))
	 * WHERE ((name = ? AND age = ?) OR(name = ? AND age = ?))
	 */
	@Test
	void testSql() {
		LambdaQueryWrapper<UserSampleWrapper> or = new LambdaQueryWrapper<UserSampleWrapper>()
			.nested(usw -> usw.eq(UserSampleWrapper::getName, "Jone").eq(UserSampleWrapper::getAge, 18))
			.or(usw2 -> usw2.eq(UserSampleWrapper::getName, "b").eq(UserSampleWrapper::getAge, 2));
		userSampleWrapperDao.selectList(or).stream().forEach(System.out::println);
	}

	@Test
	void lambdaQueryWrapper() {
		LambdaQueryWrapper<UserSampleWrapper> eq = new QueryWrapper<UserSampleWrapper>().lambda()
			.eq(UserSampleWrapper::getRoleId, "2L");
		List<UserSampleWrapper> userSampleWrappers = userSampleWrapperDao.selectList(eq);
		userSampleWrappers.stream()
			.forEach(System.out::println);
		LambdaQueryWrapper<UserSampleWrapper> eq1 = new LambdaQueryWrapper<UserSampleWrapper>().eq(UserSampleWrapper::getRoleId, "2L");
		List<UserSampleWrapper> userSampleWrappers1 = userSampleWrapperDao.selectList(eq1);
		assertEquals(userSampleWrappers.size(),userSampleWrappers1.size());

	}

	@Test
	void lambdaQueryWrapper2() {
		System.out.println("----- 带子查询(sql注入) ------");
		LambdaQueryWrapper<UserSampleWrapper> inSql = new LambdaQueryWrapper<UserSampleWrapper>()
			.inSql(UserSampleWrapper::getRoleId, "select id from user_role where id = 2");
		List<UserSampleWrapper> userSampleWrappers2 = userSampleWrapperDao.selectList(inSql);
		userSampleWrappers2.stream().forEach(System.out::println);
	}

	@Test
	void lambdaQueryWrapper3() {
		System.out.println("----- 带嵌套查询 ------");
		LambdaQueryWrapper<UserSampleWrapper> nested = new LambdaQueryWrapper<UserSampleWrapper>().nested(usw -> usw.eq(UserSampleWrapper::getRoleId, "2L")
				.or().eq(UserSampleWrapper::getRoleId, "3L"))
			.and(usw -> usw.eq(UserSampleWrapper::getAge, 20));
		userSampleWrapperDao.selectList(nested).stream().forEach(System.out::println);
	}

	@Test
	void lambdaQueryWrapper4() {
		System.out.println("----- 自定义(sql注入) ------");
		LambdaQueryWrapper<UserSampleWrapper> apply = new LambdaQueryWrapper<UserSampleWrapper>().apply("role_id = 2");
		userSampleWrapperDao.selectList(apply).stream().forEach(System.out::println);
	}
}