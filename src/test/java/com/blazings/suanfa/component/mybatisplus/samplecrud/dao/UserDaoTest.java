package com.blazings.suanfa.component.mybatisplus.samplecrud.dao;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.blazings.suanfa.component.mybatisplus.samplecrud.entity.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class UserDaoTest {
	@Autowired
	UserDao userDao;

	@Resource
	User2Dao user2Dao;

	@BeforeEach
	void setUp() {
	}

	@AfterEach
	void tearDown() {
		userDao.delete(
			new QueryWrapper<User>().lambda().eq(User::getName, "小羊").eq(User::getEmail, "abc@mp.com"));
		userDao.deleteById(10086L);

	}

	@Test
	void testGroup() {
		LambdaQueryWrapper<User> userLambdaQueryWrapper = new QueryWrapper<User>().lambda()
			.select(User::getAge)
			.groupBy(User::getAge)
			.orderByAsc(User::getAge);

		for (User user : userDao.selectList(userLambdaQueryWrapper)) {
			System.out.println(user);
		}

	}

	@Test
	void selectMaps() {
		List<Map<String, Object>> mapList = userDao.selectMaps(new QueryWrapper<User>().lambda().orderByAsc(User::getAge));
	}

	@Test
	void orderBy() {
		List<User> users = userDao.selectList(new QueryWrapper<User>().lambda().orderByAsc(User::getAge));

		List<User> users1 = userDao.selectList(new QueryWrapper<User>().lambda()
			.last("limit 2")
			.orderByAsc(User::getAge)
			.orderByDesc(User::getName));
		assertThat(users1.size()).isEqualTo(2);
	}

	@Test
	void aInsert() {
		User user = new User();
		user.setName("小羊");
		user.setAge(3);
		user.setEmail("abc@mp.com");
		assertThat(userDao.insert(user)).isGreaterThan(0);
		assertThat(user.getId()).isNotNull();
	}

	@Test
	void cUpdate() {
		User user = new User();
		user.setId(1L);
		user.setEmail("ab@c.c");
		assertThat(userDao.updateById(user)).isGreaterThan(0);

		User user1 = new User();
		user1.setId(2L);
		user1.setAge(3);
		user1.setName("mp");
		assertThat(userDao.updateById(user1)).isGreaterThan(0);

		User user2 = userDao.selectById(2);
		assertThat(user2.getAge()).isEqualTo(3);
		assertThat(user2.getName()).isEqualTo("mp");

		userDao.update(null, Wrappers.<User>lambdaUpdate()
			.eq(User::getId, 2)
			.set(User::getEmail, null)
			.set(User::getAge, 4));

		assertThat(userDao.selectById(1).getEmail()).isEqualTo("ab@c.c");

	}

	@Test
	void dSelect() {
		User user = new User();
		user.setId(10086L);
		user.setName("miemie");
		user.setEmail("miemie@baomidou.com");
		user.setAge(3);
		assertThat(userDao.insert(user)).isGreaterThan(0);

		User user1 = userDao.selectById(10086L);
		assertThat(user1.getEmail()).isEqualTo("miemie@baomidou.com");

		User user2 = userDao.selectOne(new QueryWrapper<User>().lambda().eq(User::getId, 10086));
		assertThat(user2.getName()).isEqualTo("miemie");
		assertThat(user2.getAge()).isEqualTo(3);
	}
}
