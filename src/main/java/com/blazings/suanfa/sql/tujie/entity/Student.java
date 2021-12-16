package com.blazings.suanfa.sql.tujie.entity;


import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * (Student)��ʵ����
 *
 * @author makejava
 * @since 2021-12-16 21:50:02
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

