package com.blazings.suanfa.sql.tujie.entity;


import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

/**
 * (Teacher)��ʵ����
 *
 * @author makejava
 * @since 2021-12-16 21:50:02
 */
@SuppressWarnings("serial")
@Data
public class Teacher extends Model<Teacher> {

	private Integer id;

	private String name;


}

