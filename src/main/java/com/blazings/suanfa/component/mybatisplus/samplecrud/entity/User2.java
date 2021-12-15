package com.blazings.suanfa.component.mybatisplus.samplecrud.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
import lombok.Data;

/**
 * (User2)��ʵ����
 *
 * @author makejava
 * @since 2021-12-15 11:25:10
 */
@SuppressWarnings("serial")
@Data
public class User2 extends Model<User2> {
    //主键ID
    private Long id;
    //姓名
    private String name;
    //年龄
    private Integer age;

    }

