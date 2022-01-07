package com.blazings.suanfa.sql.tujie.entity;


import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

import lombok.Data;

/**
 * (UserAddress)???????
 *
 * @author makejava
 * @since 2022-01-07 15:26:25
 */
@SuppressWarnings("serial")
@Data
public class UserAddress extends Model<UserAddress> {

	private Integer id;

	private Integer userId;

	private Integer areaId;

	private String tel;

	private String address;

	private String del;


}

