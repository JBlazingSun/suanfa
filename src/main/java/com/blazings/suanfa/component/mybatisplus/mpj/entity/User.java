package com.blazings.suanfa.component.mybatisplus.mpj.entity;


import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

import lombok.Data;

/**
 * (User)???????
 *
 * @author makejava
 * @since 2021-12-20 15:24:54
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

