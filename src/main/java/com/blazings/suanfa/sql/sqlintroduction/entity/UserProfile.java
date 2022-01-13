package com.blazings.suanfa.sql.sqlintroduction.entity;


import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

import lombok.Data;

/**
 * (UserProfile)???????
 *
 * @author makejava
 * @since 2022-01-13 10:45:49
 */
@SuppressWarnings("serial")
@Data
public class UserProfile extends Model<UserProfile> {

	private Integer id;

	private Integer deviceId;

	private String gender;

	private Integer age;

	private String university;

	private String province;

	private Float gpa;


}

