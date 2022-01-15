package com.blazings.suanfa.sql.sqlintroduction.dao;

import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class QuestionPracticeDetailDaoTest {

	@Resource
	QuestionPracticeDetailDao detailDao;

	//	/**
//	 * SQL21 浙江大学用户题目回答情况
//	 */
//	@Test
//	void name() {
//		MPJQueryWrapper<QuestionPracticeDetail> mpjQueryWrapper = new MPJQueryWrapper<QuestionPracticeDetail>()
//			.select("t.device_id",
//				"t.question_id",
//				"t.result" )
//			.innerJoin("user_profile AS u ON u.device_id = t.device_id")
//			.eq("u.university", "浙江大学");
//		List<QuestionPracticeDetail> list = detailDao.selectList(mpjQueryWrapper);
//
//	}
}