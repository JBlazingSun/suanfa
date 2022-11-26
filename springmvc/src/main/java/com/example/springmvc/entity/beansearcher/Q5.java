package com.example.springmvc.entity.beansearcher;

import com.ejlchina.searcher.bean.DbField;
import com.ejlchina.searcher.bean.SearchBean;
import lombok.Data;

@Data
@SearchBean(tables = "student s LEFT JOIN score ON score.s_id=s.s_id"
	, groupBy = "s.s_id, s.s_name")
public class Q5 {
	@DbField(value = "s.s_id")
	String stuID;
	@DbField(value = "s.s_name")
	String stuName;
	@DbField(value = "COUNT(score.s_id = s.s_id)", alias = "courseTotal")
	Double courseTotal;
	@DbField(value = "SUM(score.s_score)", alias = "sumScore")
	Double sumScore;
}
