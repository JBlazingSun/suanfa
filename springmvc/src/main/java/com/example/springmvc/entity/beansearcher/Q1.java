package com.example.springmvc.entity.beansearcher;

import com.ejlchina.searcher.bean.DbField;
import com.ejlchina.searcher.bean.SearchBean;
import com.example.springmvc.entity.beansearcher.entity.student;
import lombok.Data;

@Data
@SearchBean(tables = "student s LEFT JOIN score s01 ON s.s_id = s01.s_id AND s01.c_id = '01' LEFT JOIN score s02 ON s.s_id = s02.s_id AND s02.c_id = '02'",
	where = "s01.s_score > s02.s_score",
	autoMapTo = "s")
public class Q1 extends student {
	@DbField(value = "s01.s_score", alias = "课程01")
	int score01;
	@DbField(value = "s02.s_score", alias = "课程02")
	int score02;
}
