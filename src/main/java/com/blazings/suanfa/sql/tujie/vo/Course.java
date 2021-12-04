package com.blazings.suanfa.sql.tujie.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("Course")
public class Course {
    Integer id;
    @TableField("course_name")
    String courseName;
    @TableField("tec_id")
    int tecId;
}
