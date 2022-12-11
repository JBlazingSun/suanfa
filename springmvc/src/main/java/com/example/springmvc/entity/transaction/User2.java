package com.example.springmvc.entity.transaction;

import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;

/**
 * (User2)实体类
 *
 * @author makejava
 * @since 2022-12-11 12:22:54
 */
public class User2 implements Serializable {
    private static final long serialVersionUID = 754537566970986822L;

    @TableId
    private Integer id;
    
    private String name;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

