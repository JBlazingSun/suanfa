package com.blazings.suanfa.sql.sqlintroduction.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.blazings.suanfa.sql.sqlintroduction.entity.UserProfile;
import com.github.yulichang.query.MPJQueryWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@SpringBootTest
class UserProfileDaoTest {

	@Resource
	UserProfileDao userProfileDao;

	/**
	 *
	 */
	@Test
	void name4() {
		String sql ="SELECT\n" +
			"\tuser_profile.device_id,\n" +
			"\tuser_profile.gender,\n" +
			"\tuser_profile.age,\n" +
			"\tuser_profile.gpa \n" +
			"FROM\n" +
			"\tuser_profile \n" +
			"WHERE\n" +
			"\tuser_profile.university = '山东大学' UNION ALL\n" +
			"SELECT\n" +
			"\tuser_profile.device_id,\n" +
			"\tuser_profile.gender,\n" +
			"\tuser_profile.age,\n" +
			"\tuser_profile.gpa \n" +
			"FROM\n" +
			"\tuser_profile \n" +
			"WHERE\n" +
			"\tuser_profile.gender = 'male'";
		List<UserProfile> userProfiles = userProfileDao.dynamicSql(sql);
	}

	/**
	 * SQL24 统计每个用户的平均刷题数
	 */
	@Test
	void name3() {
		MPJQueryWrapper<UserProfile> group = new MPJQueryWrapper<UserProfile>()
			.select("t.university",
				"qd.difficult_level",
				"COUNT(t.answer_cnt)/COUNT(DISTINCT qpd.device_id)  as avg_answer_cnt")
			.innerJoin("question_practice_detail as qpd ON t.device_id = qpd.device_id")
			.innerJoin("question_detail as qd ON qpd.question_id = qd.question_id")
			.eq("t.university", "山东大学")
			.groupBy("qd.difficult_level");
		List<Map<String, Object>> maps = userProfileDao.selectMaps(group);
	}

	/**
	 * SQL23 统计每个学校各难度的用户平均刷题数
	 */
	@Test
	void name2() {
		MPJQueryWrapper<UserProfile> queryWrapper = new MPJQueryWrapper<UserProfile>()
			.select("t.university",
				"qd.difficult_level",
				"COUNT( qp.question_id ) / COUNT( DISTINCT qp.device_id ) AS avg_answer_cnt ")
			.innerJoin("question_practice_detail AS qp ON qp.device_id = t.device_id")
			.innerJoin("question_detail AS qd ON qd.question_id = qp.question_id ")
			.groupBy("t.university", "qd.difficult_level");
		List<Map<String, Object>> maps = userProfileDao.selectMaps(queryWrapper);
	}

	//	/**
	//	 * SQL22 统计每个学校的答过题的用户的平均答题数
	//	 */
	//	@Test
	//	void name1() {
	//		MPJQueryWrapper<UserProfile> group = new MPJQueryWrapper<UserProfile>()
	//			.select("t.university", "COUNT( q.question_id ) / COUNT( DISTINCT q.device_id ) AS
	// avg_answer_cnt ")
	//			.innerJoin("question_practice_detail AS q ON q.device_id = t.device_id ")
	//			.groupBy("t.university");
	//		List<Map<String, Object>> userProfiles = userProfileDao.selectMaps(group);
	//	}
}
