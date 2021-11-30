package com.blazings.suanfa.springboot.swagger.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class User {
  @ApiModelProperty(example = "yilidan")
  String name;

  int age;
  String email;
}
