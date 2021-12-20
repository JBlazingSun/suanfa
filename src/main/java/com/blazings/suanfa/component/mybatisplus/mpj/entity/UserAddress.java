package com.blazings.suanfa.component.mybatisplus.mpj.entity;


import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

import lombok.Data;

/**
 * (UserAddress)???????
 *
 * @author makejava
 * @since 2021-12-20 15:25:05
 */
@SuppressWarnings("serial")
@Data
public class UserAddress extends Model<UserAddress>{

	private Integer id;

	private Integer userId;

	private Integer areaId;

	private String tel;

	private String address;

	private String del;


}

