package com.blazings.suanfa.springboot.springmvc.controller;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.date.LocalDateTimeUtil;
import com.blazings.suanfa.springboot.springmvc.config.annotation.ICustomerGroupGet;
import com.blazings.suanfa.springboot.springmvc.config.annotation.ICustomerGroupUpdate;
import com.blazings.suanfa.springboot.springmvc.config.annotation.ICustomerValided;
import com.blazings.suanfa.springboot.springmvc.config.exception.RestfulErrorTest;
import com.blazings.suanfa.springboot.springmvc.entity.MVCUser;
import com.blazings.suanfa.springboot.springmvc.entity.ModelValidMultField;
import com.google.common.collect.Maps;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotEmpty;
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

	@GetMapping("multiField")
	public ResponseEntity<ModelValidMultField> multiField(@Validated ModelValidMultField field) {
		return ResponseEntity.ok(field);
	}

	@GetMapping("singleParam")
	public ResponseEntity<String> singleParam(@NotEmpty @ICustomerValided String paramOne, @NotEmpty String paramTwo, @NotEmpty String paramThree) {

		return ResponseEntity.ok(paramOne + " " + paramTwo + " " + paramThree);
	}

	@GetMapping("getMethod")
	public ResponseEntity<MVCUser> getMethod(@Validated(ICustomerGroupGet.class) MVCUser mvcUser) {
		mvcUser.setUserName("CrudGet" + mvcUser.getUserName());
		return ResponseEntity.ok(mvcUser);
	}

	@PostMapping("postMethod")
	public ResponseEntity<MVCUser> postMethod(@RequestBody @Validated(ICustomerGroupUpdate.class) MVCUser mvcUser) {
		mvcUser.setUserName("CrudPost" + mvcUser.getUserName());
		return ResponseEntity.ok(mvcUser);
	}

	@PutMapping("putMethod")
	public ResponseEntity<MVCUser> putMethod(@RequestBody MVCUser mvcUser) {
		mvcUser.setUserName("修改之后的username");
		mvcUser.setPassword("修改之后的password");
		mvcUser.setUpdateTime(LocalDateTime.now());
		return ResponseEntity.ok(mvcUser);
	}

	@DeleteMapping("deleteMethod")
	public ResponseEntity<MVCUser> deleteMethod(@RequestBody MVCUser mvcUser) {
		mvcUser.setUserName("deleted");
		return ResponseEntity.ok(mvcUser);
	}

	@GetMapping("errorTest")
	public ResponseEntity<MVCUser> errorTest(MVCUser mvcUser) {
		// 抛出自定义异常
		throw new RestfulErrorTest("test exception", mvcUser);
	}
}
