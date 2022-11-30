package com.example.springmvc.entity.beansearcher;

import com.ejlchina.searcher.bean.DbField;
import com.ejlchina.searcher.bean.SearchBean;

/**
 * -- 15、查询两门及其以上不及格课程的同学的学号，姓名及其平均成绩
 * <p>
 * SELECT
 * s.s_id,
 * s.s_name,
 * AVG(score.s_score) AS avg
 * FROM student s
 * LEFT JOIN score ON score.s_id=s.s_id
 * WHERE s.s_id IN (
 * SELECT
 * score.s_id
 * FROM score
 * WHERE score.s_score<60
 * GROUP BY score.s_id
 * HAVING COUNT(1) >=2
 * )
 * GROUP BY s.s_id,s.s_name
 */

@SearchBean(tables = "student s LEFT JOIN score ON score.s_id=s.s_id",
	where = "s.s_id IN (SELECT score.s_id FROM score WHERE score.s_score<60 GROUP BY score.s_id HAVING COUNT(1) >=2)",
	groupBy = "s.s_id,s.s_name")
public class Q15 {
	@DbField(value = "s.s_id")
	String id;
	@DbField(value = "s.s_name")
	String name;
	@DbField(value = "AVG(score.s_score)", alias = "avg")
	double avg;
}
