package com.blazings.suanfa.sql.tujie.entity;


import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

/**
 * (Score)��ʵ����
 *
 * @author makejava
 * @since 2021-12-16 21:50:02
 */
@SuppressWarnings("serial")
@Data
public class Score extends Model<Score> {

	private Integer id;
	//学号
	private Integer stuId;
	//课程号
	private Integer courseId;
	//成绩
	private Object score;


}

