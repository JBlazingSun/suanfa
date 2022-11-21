package com.example.springmvc.entity;

import java.io.Serializable;

/**
 * (User)ʵ����
 *
 * @author makejava
 * @since 2022-11-21 22:02:30
 */
public class User implements Serializable {
    private static final long serialVersionUID = 757921520317698718L;

    private Long id;

    private String name;

    private Integer age;

    private Integer point;


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

    public Integer getPoint() {
        return point;
    }

    public void setPoint(Integer point) {
        this.point = point;
    }

}

