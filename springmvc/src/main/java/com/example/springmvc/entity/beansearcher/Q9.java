package com.example.springmvc.entity.beansearcher;

import com.ejlchina.searcher.bean.SearchBean;
import com.example.springmvc.entity.beansearcher.entity.student;

@SearchBean(tables = "student s LEFT JOIN score s01 ON s01.s_id=s.s_id LEFT JOIN score s02 ON s02.s_id=s.s_id",
	where = "s01.c_id='01' AND s02.c_id='02'")
public class Q9 extends student {
}
