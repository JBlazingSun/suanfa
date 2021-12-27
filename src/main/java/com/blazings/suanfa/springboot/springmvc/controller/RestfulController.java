package com.blazings.suanfa.springboot.springmvc.controller;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.date.LocalDateTimeUtil;
import com.blazings.suanfa.springboot.springmvc.config.annotation.ICustomerValided;
import com.blazings.suanfa.springboot.springmvc.config.exception.RestfulErrorTest;
import com.blazings.suanfa.springboot.springmvc.entity.User;
import com.google.common.collect.Maps;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.hibernate.validator.constraints.Length;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.HashMap;

@RestController
@RequestMapping("restful")
@Validated
public class RestfulController {
	@GetMapping("hello")
	public ResponseEntity<String> hello() {
		// 获取秒数, 10位时间戳
		Long second = LocalDateTime.now().toEpochSecond(ZoneOffset.of("+8"));
		// 获取毫秒数, 13位时间戳
		Long milliSecond = LocalDateTimeUtil.toEpochMilli(LocalDateTime.now());
		return ResponseEntity.ok("hello  " + second + " " + milliSecond);
	}

	@GetMapping("hello12")
	public ResponseEntity<HashMap<@Nullable String, @Nullable Object>> hello12() {
		LocalDateTime time = LocalDateTimeUtil.of(System.currentTimeMillis());
		HashMap<@Nullable String, @Nullable Object> map = Maps.newHashMap();
		map.put("hello", null);
		map.put("DateUtil.now", DateUtil.now());
		map.put("LocalDateTime time", time);
		return ResponseEntity.ok(map);
	}

	@GetMapping("singleParam")
	public ResponseEntity<String> singleParam(@NotEmpty @ICustomerValided String paramOne, @NotEmpty String paramTwo, @NotEmpty String paramThree) {

		return ResponseEntity.ok(paramOne + " " + paramTwo + " " + paramThree);
	}

	@GetMapping("getMethod")
	public ResponseEntity<User> getMethod(@Validated User user) {
		user.setUserName("CrudGet"+user.getUserName());
		return ResponseEntity.ok(user);
	}

	@PostMapping("postMethod")
	public ResponseEntity<User> postMethod(@RequestBody User user) {
		user.setUserName("CrudPost");
		return ResponseEntity.ok(user);
	}

	@PutMapping("putMethod")
	public ResponseEntity<User> putMethod(@RequestBody User user) {
		user.setUserName("修改之后的username");
		user.setPassword("修改之后的password");
		user.setUpdateTime(LocalDateTime.now());
		return ResponseEntity.ok(user);
	}

	@DeleteMapping("deleteMethod")
	public ResponseEntity<User> deleteMethod(@RequestBody User user) {
		user.setUserName("deleted");
		return ResponseEntity.ok(user);
	}

	@GetMapping("errorTest")
	public ResponseEntity<User> errorTest(User user) {
		// 抛出自定义异常
		throw new RestfulErrorTest("test exception", user);
	}
}
