package com.blazings.suanfa.component.mybatisplus.userpagination.entity;


import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

/**
 * (Children)��ʵ����
 *
 * @author makejava
 * @since 2021-12-16 20:12:15
 */
@SuppressWarnings("serial")
@Data
public class Children extends Model<Children> {
	//主键ID
	private Long id;
	//姓名
	private String name;
	//上级ID
	private Long userPaginationId;


}

