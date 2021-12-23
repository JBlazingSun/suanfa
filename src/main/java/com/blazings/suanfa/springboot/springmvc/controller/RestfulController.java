package com.blazings.suanfa.springboot.springmvc.controller;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.date.LocalDateTimeUtil;
import com.blazings.suanfa.springboot.springmvc.config.exception.RestfulErrorTest;
import com.blazings.suanfa.springboot.springmvc.entity.User;
import com.google.common.collect.Maps;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.HashMap;

@RestController
@RequestMapping("restful")
public class RestfulController {
	@GetMapping("hello")
	public ResponseEntity<String> Hello() {
		//获取秒数, 10位时间戳
		Long second = LocalDateTime.now().toEpochSecond(ZoneOffset.of("+8"));
		//获取毫秒数, 13位时间戳
		Long milliSecond = LocalDateTimeUtil.toEpochMilli(LocalDateTime.now());
		return ResponseEntity.ok("hello  " + second+ " "+milliSecond );
	}

	@GetMapping("hello12")
	public ResponseEntity<HashMap<@Nullable String, @Nullable Object>> Hello12() {
		LocalDateTime time = LocalDateTimeUtil.of(System.currentTimeMillis());
		HashMap<@Nullable String, @Nullable Object> map = Maps.newHashMap();
		map.put("hello", "hello12");
		map.put("DateUtil.now", DateUtil.now());
		map.put("LocalDateTime time", time);
		return ResponseEntity.ok(map);
	}

	@PostMapping("errortest")
	public ResponseEntity<User> PostPublicMethod(@RequestBody User user) {

		return ResponseEntity.ok(user);
	}

	@GetMapping("errortest")
	public ResponseEntity<User> GetPublicMethod(User user) {
		// 抛出自定义异常
		throw new RestfulErrorTest("test exception", user);
	}
}
