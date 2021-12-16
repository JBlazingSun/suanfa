package com.blazings.suanfa.component.mybatisplus.userpagination.entity;


import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

/**
 * (UserPagination)��ʵ����
 *
 * @author makejava
 * @since 2021-12-16 20:11:57
 */
@SuppressWarnings("serial")
@Data
public class UserPagination extends Model<UserPagination> {
	//主键ID
	private Long id;
	//姓名
	private String name;
	//年龄
	private Integer age;
	//邮箱
	private String email;


}

