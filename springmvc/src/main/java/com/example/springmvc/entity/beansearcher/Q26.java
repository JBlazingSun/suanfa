package com.example.springmvc.entity.beansearcher;

import com.ejlchina.searcher.bean.DbField;
import com.ejlchina.searcher.bean.SearchBean;

/**
 * -- 26、查询每门课程被选修的学生数
 * SELECT
 * ANY_VALUE(score.c_id) c_id,
 * COUNT(score.c_id) as cou
 * FROM score
 * GROUP BY score.c_id
 */
@SearchBean(tables = "score",
	groupBy = "score.c_id")
public class Q26 {
	@DbField(value = "ANY_VALUE(score.c_id)", alias = "c_id")
	String cid;

	@DbField(value = "COUNT(score.c_id)")
	Double count;
}
