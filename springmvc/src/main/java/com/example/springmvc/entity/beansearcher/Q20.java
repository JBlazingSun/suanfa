package com.example.springmvc.entity.beansearcher;

import com.ejlchina.searcher.bean.DbField;
import com.ejlchina.searcher.bean.SearchBean;
import lombok.Data;

/**
 * SELECT
 * score.s_id,
 * s.s_name,
 * SUM(score.s_score) as sum
 * FROM score
 * LEFT JOIN student s ON score.s_id=s.s_id
 * GROUP BY score.s_id
 * ORDER BY SUM(score.s_score) DESC
 */
@Data
@SearchBean(tables = "score LEFT JOIN student s ON score.s_id=s.s_id",
	groupBy = "score.s_id",
	orderBy = "SUM(score.s_score) DESC")
public class Q20 {
	@DbField(value = "score.s_id")
	String sid;
	@DbField(value = "s.s_name")
	String sName;
	@DbField(value = "SUM(score.s_score)")
	Double sum;
}
