package com.example.springmvc.entity.beansearcher;

import com.ejlchina.searcher.bean.DbField;
import com.ejlchina.searcher.bean.SearchBean;
import com.example.springmvc.entity.beansearcher.entity.student;
import lombok.Data;

@SearchBean(tables = "student s LEFT JOIN score ON score.s_id=s.s_id",
	where = "score.s_id!='01'")
@Data
public class Q13 extends student {
	@DbField(value = "score.c_id")
	String cid;
}
