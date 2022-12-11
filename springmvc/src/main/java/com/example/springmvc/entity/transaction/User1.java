package com.example.springmvc.entity.transaction;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;

/**
 * (User1)实体类
 *
 * @author makejava
 * @since 2022-12-11 12:22:20
 */
public class User1 implements Serializable {
    private static final long serialVersionUID = -54073992995217064L;

    @TableId(type = IdType.AUTO)
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

