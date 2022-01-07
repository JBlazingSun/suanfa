package com.blazings.suanfa.sql.tujie.entity;


import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

import lombok.Data;

/**
 * (Teacher)???????
 *
 * @author makejava
 * @since 2022-01-07 15:13:26
 */
@SuppressWarnings("serial")
@Data
public class Teacher extends Model<Teacher> {

	private Integer id;

	private String name;


}

