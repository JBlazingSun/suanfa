package com.blazings.suanfa.sql.tujie.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.blazings.suanfa.sql.tujie.entity.Score;
import com.blazings.suanfa.sql.tujie.service.ScoreService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ScoreDaoTest {
	@Autowired
	ScoreDao scoreDao;

	@Autowired
	ScoreService scoreService;
	/**
	 * 查询男生、女生人数
	 */
	@Test
	void name4() {
		
	}

	/**
	 * 查询每门课程被选修的学生数
	 */
	@Test
	void name3() {
		QueryWrapper<Score> course_id = new QueryWrapper<Score>()
			.select("course_id,COUNT(stu_id) as stuTotal")
			.groupBy("course_id");
		List<Map<String, Object>> maps = scoreDao.selectMaps(course_id);
	}
	/**
	 * 查询课程编号为“0002”的总成绩
	 */
	@Test
	void name1() {
		QueryWrapper<Score> course_id = new QueryWrapper<Score>()
			.select("ifnull(sum(score),0) as courseTotal")
			.eq("course_id", 2);
		Map<String, Object> map = scoreService.getMap(course_id);
		assertEquals(Double.valueOf(map.get("courseTotal").toString()),230.00);
	}
	/**
	 * 查询选了课程的学生人数
	 */
	@Test
	void name() {
		QueryWrapper<Score> select = new QueryWrapper<Score>()
			.select("COUNT( DISTINCT score.stu_id ) as selectCourseStuTotal");
		Map<String, Object> map = scoreService.getMap(select);
		assertEquals(Double.valueOf(map.get("selectCourseStuTotal").toString()),4);
	}
	/**
	 * 查询各科成绩最高和最低的分， 以如下的形式显示：课程号，最高分，最低分
	 */
	@Test
	void name2() {
		QueryWrapper<Score> course_id = new QueryWrapper<Score>()
			.select("score.course_id, \n" +
				"\tMAX(score.score) AS maxScore, \n" +
				"\tMIN(score.score) AS minScore")
			.groupBy("course_id");
		List<Map<String, Object>> scores = scoreService.listMaps(course_id);
	}

}