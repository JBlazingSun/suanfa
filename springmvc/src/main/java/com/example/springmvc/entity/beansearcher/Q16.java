package com.example.springmvc.entity.beansearcher;

import com.ejlchina.searcher.bean.DbField;
import com.ejlchina.searcher.bean.SearchBean;
import com.example.springmvc.entity.beansearcher.entity.student;

/**
 * -- 16、检索"01"课程分数小于60，按分数降序排列的学生信息
 * <p>
 * SELECT
 * s.*,
 * score.c_id,
 * score.s_score
 * FROM student s
 * LEFT JOIN score ON score.s_id=s.s_id
 * WHERE score.c_id='01' AND score.s_score<60
 * ORDER BY score.s_score DESC
 */

@SearchBean(tables = "student s LEFT JOIN score ON score.s_id=s.s_id",
	where = "score.c_id='01' AND score.s_score<60",
	orderBy = "score.s_score DESC")
public class Q16 extends student {
	@DbField(value = "score.s_score")
	Double score;
	@DbField(value = "score.c_id")
	String cid;
}
