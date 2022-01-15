package com.blazings.suanfa.sql.sqlintroduction.dao;

import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class UserProfileDaoTest {

	@Resource
	UserProfileDao userProfileDao;

//	/**
//	 * SQL22 统计每个学校的答过题的用户的平均答题数
//	 */
//	@Test
//	void name1() {
//		MPJQueryWrapper<UserProfile> group = new MPJQueryWrapper<UserProfile>()
//			.select("t.university", "COUNT( q.question_id ) / COUNT( DISTINCT q.device_id ) AS avg_answer_cnt ")
//			.innerJoin("question_practice_detail AS q ON q.device_id = t.device_id ")
//			.groupBy("t.university");
//		List<Map<String, Object>> userProfiles = userProfileDao.selectMaps(group);
//	}
}