package com.example.springmvc.entity.beansearcher;

import com.ejlchina.searcher.bean.SearchBean;
import com.example.springmvc.entity.beansearcher.entity.student;

@SearchBean(tables = "student s",
	where = "s.s_id NOT IN(SELECT score.s_id FROM score  WHERE score.c_id = ( SELECT c.c_id FROM course c WHERE c.t_id = ( SELECT t.t_id FROM teacher t WHERE t_name='张三')))")
public class Q14 extends student {
}
