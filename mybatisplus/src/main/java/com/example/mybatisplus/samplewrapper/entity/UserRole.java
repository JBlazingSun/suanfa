package com.example.mybatisplus.samplewrapper.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;

import lombok.Data;

/**
 * (UserRole)��ʵ����
 *
 * @author makejava
 * @since 2021-12-16 16:14:11
 */
@SuppressWarnings("serial")
@Data
public class UserRole extends Model<UserRole> {
	//主键ID
	private Long id;
	//角色名
	private String roleName;
	//角色描述
	private String roleDescribe;


}

