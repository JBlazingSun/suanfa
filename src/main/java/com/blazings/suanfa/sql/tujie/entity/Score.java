package com.blazings.suanfa.sql.tujie.entity;


import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

import lombok.Data;

/**
 * (Score)???????
 *
 * @author makejava
 * @since 2022-01-07 15:13:24
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

