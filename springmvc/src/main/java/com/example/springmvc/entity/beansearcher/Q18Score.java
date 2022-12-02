package com.example.springmvc.entity.beansearcher;

import com.ejlchina.searcher.bean.DbField;
import com.ejlchina.searcher.bean.SearchBean;
import lombok.Data;

/**
 * -- 18.查询各科成绩最高分、最低分和平均分：以如下形式显示：课程ID，课程name，最高分，最低分，平均分，及格率，中等率，优良率，优秀率
 * SELECT
 * sc.c_id,
 * sc.s_score,
 * c.c_name
 * FROM score sc
 * LEFT JOIN course c ON sc.c_id=c.c_id
 */
@SearchBean(tables = "score sc LEFT JOIN course c ON sc.c_id=c.c_id")
@Data
public class Q18Score {
	@DbField(value = "sc.c_id")
	String cid;
	@DbField(value = "sc.s_score")
	Double s_score;
	@DbField(value = "c.c_name")
	String cName;
}
