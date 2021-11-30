package com.blazings.suanfa.springboot.swagger.controller;

import com.blazings.suanfa.springboot.swagger.vo.User;
import com.google.common.collect.Lists;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Api(value = "SwaggerContorller")
@RestController
@RequestMapping("swagger")
public class swaggerContorller {
  @ApiOperation("SwaggerOperation")
  @GetMapping("swagger")
  public ResponseEntity<User> Swagger() {
    User user = new User();
    user.setName("aa");
    user.setAge(22);
    user.setEmail("blazings@vip.qq.com");

    return ResponseEntity.ok(user);
  }

  @ApiOperation("SwaggerListUser")
  @GetMapping("SwaggerListUser")
  public ResponseEntity<List<User>> SwaggerListUser() {
    ArrayList<User> objects = Lists.newArrayList();
    User user = new User();
    user.setName("aa");
    user.setAge(22);
    user.setEmail("blazings@vip.qq.com");
    objects.add(user);
    User user2 = new User();
    user2.setName("bb");
    user2.setAge(33);
    user2.setEmail("328801898@qq.com");
    objects.add(user2);
    return ResponseEntity.ok(objects);
  }
}
