package com.blazings.suanfa.sql.sqlintroduction.dao;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class UserProfileDaoTest {

  @Resource UserProfileDao userProfileDao;

  /** SQL23 统计每个学校各难度的用户平均刷题数 */
  @Test
  void name2() {}

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
  /**
   * SELECT t.university, qd.difficult_level, COUNT( qp.question_id ) / COUNT( DISTINCT qp.device_id
   * ) AS avg_answer_cnt FROM user_profile AS t INNER JOIN question_practice_detail AS qp ON
   * qp.device_id = t.device_id INNER JOIN question_detail AS qd ON qd.question_id = qp.question_id
   * GROUP BY t.university, qd.difficult_level
   */
}
