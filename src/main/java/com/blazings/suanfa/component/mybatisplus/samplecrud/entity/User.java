package com.blazings.suanfa.component.mybatisplus.samplecrud.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

/**
 * (User)表实体类
 *
 * @author makejava
 * @since 2021-12-14 12:46:52
 */
@SuppressWarnings("serial")
@Data
public class User extends Model<User> {
    //主键ID
    private Long id;
    //姓名
    private String name;
    //年龄
    private Integer age;
    //邮箱
    private String email;

    }

