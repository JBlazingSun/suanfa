package com.blazings.suanfa.component.mybatisplus.controller;

import cn.hutool.core.date.DateUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("mybatisplus")
public class MybatisPlusController {
    @GetMapping("hello")
    public ResponseEntity<String> Hello(){
        return ResponseEntity.ok("Hello  "+ DateUtil.now());
    }
}
