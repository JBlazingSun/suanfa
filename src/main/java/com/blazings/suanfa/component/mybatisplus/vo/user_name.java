package com.blazings.suanfa.component.mybatisplus.vo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("user_name")
public class user_name {
    int id;
    String name;
    String userName;
    String mjson;
}
