package com.example.springmvc.entity.beansearcher;

import com.ejlchina.searcher.bean.SearchBean;
import com.example.springmvc.entity.beansearcher.entity.student;
import lombok.Data;

@Data
@SearchBean(tables = "student s LEFT JOIN score ON score.s_id=s.s_id LEFT JOIN course c ON score.c_id=c.c_id LEFT JOIN teacher t ON t.t_id=c.t_id",
	where = "t.t_name='张三'")
public class Q7 extends student {
}
