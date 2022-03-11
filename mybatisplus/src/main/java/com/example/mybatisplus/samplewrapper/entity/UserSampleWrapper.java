package com.example.mybatisplus.samplewrapper.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

/**
 * (UserSampleWrapper)��ʵ����
 *
 * @author makejava
 * @since 2021-12-16 15:34:01
 */
@SuppressWarnings("serial")
@Data
public class UserSampleWrapper extends Model<UserSampleWrapper> {
    //主键ID
    private Long id;
    //姓名
    private String name;
    //年龄
    private Integer age;
    //邮箱
    private String email;
    //角色ID
    private Long roleId;


    }

