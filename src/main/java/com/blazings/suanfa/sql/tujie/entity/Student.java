package com.blazings.suanfa.sql.tujie.entity;


import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.Data;

/**
 * (Student)???????
 *
 * @author makejava
 * @since 2022-01-07 15:13:25
 */
@SuppressWarnings("serial")
@Data
public class Student extends Model<Student> {
	//学号
	private Long id;
	//名字
	private String name;
	//出生日期
	private LocalDateTime birth;
	//性别
	private String gender;


}

