package com.example.springmvc.entity.beansearcher;

import com.ejlchina.searcher.bean.DbField;
import com.ejlchina.searcher.bean.SearchBean;
import lombok.Data;

/**
 * -- 35、查询所有学生的课程及分数情况；
 * SELECT
 * s.s_id,
 * s.s_name,
 * score.c_id,
 * c.c_name,
 * score.s_score
 * FROM student s
 * LEFT JOIN score ON score.s_id=s.s_id
 * LEFT JOIN course c ON c.c_id=score.c_id
 */

@Data
@SearchBean(tables = "student s LEFT JOIN score ON score.s_id=s.s_id LEFT JOIN course c ON c.c_id=score.c_id")
public class Q35AllScore {
	@DbField(value = "s.s_id")
	String s_id;
	@DbField(value = "s.s_name")
	String s_name;
	@DbField(value = "score.c_id")
	String c_id;
	@DbField(value = "c.c_name")
	String c_name;
	@DbField(value = "score.s_score")
	Double s_score;
}
