package com.example.springmvc.entity.beansearcher;


import com.ejlchina.searcher.bean.DbField;
import com.ejlchina.searcher.bean.DbIgnore;
import com.ejlchina.searcher.bean.SearchBean;
import lombok.Data;

import java.util.HashMap;

/**
 * SELECT
 * score.s_id,
 * AVG(score.s_score) as avg
 * FROM score
 * GROUP BY score.s_id
 * ORDER BY AVG(score.s_score) DESC
 */
@Data
@SearchBean(tables = "score",
	groupBy = "score.s_id",
	orderBy = "AVG(score.s_score) DESC")
public class Q17Avg {
	@DbField(value = "score.s_id")
	String sid;
	@DbField(value = "AVG(score.s_score)", alias = "avg")
	Double avg;
	@DbIgnore
	HashMap cid_score = new HashMap();
}
