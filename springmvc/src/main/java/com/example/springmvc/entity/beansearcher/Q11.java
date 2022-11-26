package com.example.springmvc.entity.beansearcher;

import com.ejlchina.searcher.bean.SearchBean;
import com.example.springmvc.entity.beansearcher.entity.student;

@SearchBean(tables = "student AS s LEFT JOIN score ON s.s_id = score.s_id",
	groupBy = "s.s_id",
	having = "COUNT(score.c_id) < :courseNumber:")
public class Q11 extends student {
}
