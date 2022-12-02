package com.example.springmvc.entity.beansearcher;
//-- 21、查询不同老师所教不同课程平均分从高到低显示

import com.ejlchina.searcher.bean.DbField;
import com.ejlchina.searcher.bean.SearchBean;
import com.example.springmvc.entity.beansearcher.entity.teacher;

/**
 * SELECT
 * t.t_id,
 * t.t_name,
 * c.c_id,
 * SUM(score.s_score)/COUNT(score.s_id) as avg
 * FROM score
 * LEFT JOIN course c ON c.c_id=score.c_id
 * LEFT JOIN teacher t ON t.t_id=c.t_id
 * GROUP BY t.t_id,c.c_id
 * ORDER BY avg DESC
 */
@SearchBean(tables = "score LEFT JOIN course c ON c.c_id=score.c_id LEFT JOIN teacher t ON t.t_id=c.t_id",
	groupBy = "t.t_id,c.c_id",
	orderBy = "avg DESC")
public class Q21 extends teacher {
	@DbField(value = "t.t_id")
	String t_id;
	@DbField(value = "t.t_name")
	String t_name;
	@DbField(value = "c.c_id")
	String c_id;
	@DbField(value = "SUM(score.s_score)/COUNT(score.s_id)", alias = "avg")
	Double avg;
}
