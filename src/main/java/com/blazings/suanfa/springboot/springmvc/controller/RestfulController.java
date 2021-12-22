package com.blazings.suanfa.springboot.springmvc.controller;

import cn.hutool.core.date.DateUtil;
import com.blazings.suanfa.springboot.springmvc.config.exception.RestfulErrorTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("restful")
public class RestfulController {
	@GetMapping("hello")
	public ResponseEntity<String> Hello() {
		return ResponseEntity.ok("hello  " + DateUtil.now());
	}

	@GetMapping("hello12")
	public ResponseEntity<String> Hello12() {
		return ResponseEntity.ok("hello12  " + DateUtil.now());
	}

  @GetMapping("errortest")
  public Object PublicMethod(String id) {
    // 抛出自定义异常
    throw new RestfulErrorTest("test exception", id);
	}
}
