package com.blazings.suanfa.component.mybatisplus.mpj.entity;


import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

import lombok.Data;

/**
 * (Area)???????
 *
 * @author makejava
 * @since 2021-12-20 15:24:35
 */
@SuppressWarnings("serial")
@Data
public class Area extends Model<Area>{

	private Integer id;

	private String province;

	private String city;

	private String area;

	private String postcode;

	private String del;


}

