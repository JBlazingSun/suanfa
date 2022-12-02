package com.example.springmvc.entity.beansearcher;

import com.ejlchina.searcher.bean.DbField;
import com.ejlchina.searcher.bean.SearchBean;
import com.example.springmvc.entity.beansearcher.entity.student;

/**
 * SELECT
 * s.*,
 * score.s_score,
 * score.c_id
 * FROM student s
 * LEFT JOIN score ON s.s_id=score.s_id
 * WHERE s.s_id IN (
 * <p>
 * )
 */
@SearchBean(tables = "student s LEFT JOIN score ON s.s_id=score.s_id",
	where = "s.s_id IN ( :top2_3: )")
public class Q22 extends student {
	@DbField(value = "score.s_score")
	Double s_score;
	@DbField(value = "score.c_id")
	String c_id;
}
