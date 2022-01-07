package com.blazings.suanfa.sql.tujie.entity;


import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

import lombok.Data;

/**
 * (Course)???????
 *
 * @author makejava
 * @since 2022-01-07 15:13:23
 */
@SuppressWarnings("serial")
@Data
public class Course extends Model<Course> {
	//课程号
	private Integer id;

	private String courseName;

	private Integer tecId;


}

