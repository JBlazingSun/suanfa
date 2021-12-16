package com.blazings.suanfa.sql.tujie.entity;


import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

/**
 * (Course)��ʵ����
 *
 * @author makejava
 * @since 2021-12-16 21:50:01
 */
@SuppressWarnings("serial")
@Data
public class Course extends Model<Course> {
	//课程号
	private Integer id;

	private String courseName;

	private Integer tecId;


}

