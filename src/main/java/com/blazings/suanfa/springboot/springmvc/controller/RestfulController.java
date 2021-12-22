package com.blazings.suanfa.springboot.springmvc.controller;

import cn.hutool.core.date.DateUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("restful")
public class RestfulController {
	@GetMapping("hello")
	public ResponseEntity<String> Hello(){
		return ResponseEntity.ok("hello  "+ DateUtil.now());
	}
}
