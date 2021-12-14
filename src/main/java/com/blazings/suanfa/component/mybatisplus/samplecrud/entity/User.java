package com.blazings.suanfa.component.mybatisplus.samplecrud.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;

/**
 * (User)表实体类
 *
 * @author makejava
 * @since 2021-12-14 12:46:52
 */
@SuppressWarnings("serial")
public class User extends Model<User> {
    //主键ID
    private Long id;
    //姓名
    private String name;
    //年龄
    private Integer age;
    //邮箱
    private String email;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    }

