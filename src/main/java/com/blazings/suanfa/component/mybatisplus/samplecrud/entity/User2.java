package com.blazings.suanfa.component.mybatisplus.samplecrud.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;

/**
 * (User2)表实体类
 *
 * @author makejava
 * @since 2021-12-14 11:21:47
 */
@SuppressWarnings("serial")
public class User2 extends Model<User2> {
    //主键ID
    private Long id;
    //姓名
    private String name;
    //年龄
    private Integer age;


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

    }

