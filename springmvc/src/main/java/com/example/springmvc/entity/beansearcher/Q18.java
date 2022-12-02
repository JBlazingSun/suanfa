package com.example.springmvc.entity.beansearcher;

//-- 18.查询各科成绩最高分、最低分和平均分：以如下形式显示：课程ID，课程name，最高分，最低分，平均分，及格率，中等率，优良率，优秀率

import lombok.Data;

@Data
public class Q18 {
	String cid;
	String cName;
	Double topScore;
	Double minScore;
	Double avgScore;
}
