package com.blazings.suanfa.sql.tujie.entity;


import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

import lombok.Data;

/**
 * (Area)???????
 *
 * @author makejava
 * @since 2022-01-07 15:13:23
 */
@SuppressWarnings("serial")
@Data
public class Area extends Model<Area> {

	private Integer id;

	private String province;

	private String city;

	private String area;

	private String postcode;

	private String del;


}

