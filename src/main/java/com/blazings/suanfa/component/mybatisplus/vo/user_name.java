package com.blazings.suanfa.component.mybatisplus.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("user_name")
public class user_name {
    @TableId(type = IdType.AUTO)
    int id;
    String name;
    String userName;
    String mjson;
}
