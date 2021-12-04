package com.blazings.suanfa.sql.tujie.vo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("Student")
public class Student {
    Integer id;
    String name;
    LocalDateTime birth;
    String gender;
}
