package com.example.springmvc.entity;

import com.ejlchina.searcher.bean.SearchBean;

import java.io.Serializable;

/**
 * (User)ʵ����
 *
 * @author makejava
 * @since 2022-11-21 00:29:09
 */
@SearchBean
public class User implements Serializable {
    private static final long serialVersionUID = -91785002130377908L;

    private Long id;

    private String name;

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

