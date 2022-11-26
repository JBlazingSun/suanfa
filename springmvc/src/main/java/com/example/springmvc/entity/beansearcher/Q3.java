package com.example.springmvc.entity.beansearcher;

import com.ejlchina.searcher.bean.DbField;
import com.ejlchina.searcher.bean.SearchBean;
import lombok.Data;

import java.math.BigDecimal;

@Data
@SearchBean(tables = "student s LEFT JOIN score ON score.s_id=s.s_id",
	groupBy = "s.s_id",
	having = "AVG(score.s_score)>=60")
public class Q3 {
	@DbField(value = "s.s_id")
	String stuId;
	@DbField(value = "s.s_name")
	String stuName;
	@DbField(value = "AVG(score.s_score)", alias = "avgScore")
	BigDecimal avgScore;
}
