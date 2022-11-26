package com.example.springmvc.entity.beansearcher;

import com.ejlchina.searcher.bean.DbField;
import com.ejlchina.searcher.bean.SearchBean;
import lombok.Data;

@Data
@SearchBean(tables = "teacher t",
	where = "t.t_name LIKE '李%'")
public class Q6 {
	@DbField(value = "COUNT(t.t_id)", alias = "nameLiTotal")
	int nameLiTotal;
}
