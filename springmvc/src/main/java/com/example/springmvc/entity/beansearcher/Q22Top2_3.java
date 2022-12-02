package com.example.springmvc.entity.beansearcher;

import com.ejlchina.searcher.bean.DbField;
import com.ejlchina.searcher.bean.SearchBean;
import lombok.Data;
//-- 22、查询所有课程的成绩第2名到第3名的学生信息及该课程成绩

/**
 * SELECT
 * score.s_id,
 * SUM(score.s_score) as sum
 * FROM score
 * GROUP BY score.s_id
 * ORDER BY sum DESC
 * LIMIT 1,2
 */
@SearchBean(tables = "score",
	groupBy = "score.s_id",
	orderBy = "sum DESC")
@Data
public class Q22Top2_3 {
	@DbField(value = "score.s_id")
	String s_id;
	@DbField(value = "SUM(score.s_score)", alias = "sum")
	Double sum;
}
