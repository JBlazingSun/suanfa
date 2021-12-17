package com.blazings.suanfa.sql.tujie.dao;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.blazings.suanfa.sql.tujie.entity.Score;
import com.blazings.suanfa.sql.tujie.entity.Student;
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
	 * 查询学生的总成绩并进行排名
	 */
	@Test
	void name8() {
		QueryWrapper<Score> scoreQueryWrapper = new QueryWrapper<Score>()
			.select("stu_id,SUM(score.score) as totalScore")
			.groupBy("stu_id")
			.orderByDesc("totalScore");
		List<Map<String, Object>> maps = scoreDao.selectMaps(scoreQueryWrapper);
	}

	/**
	 * 查询每门课程的平均成绩，结果按平均成绩升序排序，平均成绩相同时，按课程号降序排列
	 */
	@Test
	void name7() {
		QueryWrapper<Score> scoreQueryWrapper = new QueryWrapper<Score>()
			.select("course_id,AVG(score) as avgScore")
			.groupBy("course_id")
			.orderByAsc("avgScore")
			.orderByDesc("course_id");
		List<Map<String, Object>> maps = scoreDao.selectMaps(scoreQueryWrapper);
	}

	/**
	 * 查询不及格的课程并按课程号从大到小排列
	 */
	@Test
	void name6() {
		LambdaQueryWrapper<Score> scoreLambdaQueryWrapper = new LambdaQueryWrapper<Score>()
			.le(Score::getScore, 60)
			.orderByDesc(Score::getCourseId);
		List<Score> scores = scoreDao.selectList(scoreLambdaQueryWrapper);
	}

	/**
	 * 查询至少选修两门课程的学生学号
	 */
	@Test
	void name5() {
		QueryWrapper<Score> having = new QueryWrapper<Score>()
			.select("stu_id")
			.groupBy("stu_id")
			.having("COUNT(course_id)>=2");
		List<Score> scores = scoreDao.selectList(having);
	}

	/**
	 * 查询平均成绩大于60分学生的学号和平均成绩
	 */
	@Test
	void name4() {
		QueryWrapper<Score> gt = new QueryWrapper<Score>()
			.select("stu_id,AVG(score.score) as avgScore")
			.groupBy("stu_id")
			.having("AVG(score.score) > 60");
		List<Map<String, Object>> maps = scoreDao.selectMaps(gt);
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