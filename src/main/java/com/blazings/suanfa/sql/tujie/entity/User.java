package com.blazings.suanfa.sql.tujie.entity;


import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

import lombok.Data;

/**
 * (User)???????
 *
 * @author makejava
 * @since 2022-01-07 15:25:42
 */
@SuppressWarnings("serial")
@Data
public class User extends Model<User> {

	private Integer id;

	private String name;

	private Integer sex;

	private String headImg;

	private String del;


}

