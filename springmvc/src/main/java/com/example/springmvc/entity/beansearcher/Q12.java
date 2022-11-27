package com.example.springmvc.entity.beansearcher;

import com.ejlchina.searcher.bean.SearchBean;
import com.example.springmvc.entity.beansearcher.entity.student;

@SearchBean(tables = "student s",
	where = "s_id IN ( SELECT score.s_id FROM score WHERE score.c_id IN ( SELECT sc.c_id FROM score sc WHERE sc.s_id = '01' ) ) AND s.s_id != '01'")
public class Q12 extends student {

}
