package com.blazings.suanfa.springboot.springmvc.controller;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.date.LocalDateTimeUtil;
import cn.hutool.cron.CronUtil;
import cn.hutool.cron.task.Task;
import com.blazings.suanfa.springboot.springmvc.config.annotation.ICustomerGroupGet;
import com.blazings.suanfa.springboot.springmvc.config.annotation.ICustomerGroupUpdate;
import com.blazings.suanfa.springboot.springmvc.config.annotation.ICustomerValided;
import com.blazings.suanfa.springboot.springmvc.config.exception.RestfulErrorTest;
import com.blazings.suanfa.springboot.springmvc.entity.MVCUser;
import com.blazings.suanfa.springboot.springmvc.entity.ModelValidMultField;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class RestfulController {
	@GetMapping("hello")
	public String hello() {
		// 获取秒数, 10位时间戳
		Long second = LocalDateTime.now().toEpochSecond(ZoneOffset.of("+8"));
		// 获取毫秒数, 13位时间戳
		Long milliSecond = LocalDateTimeUtil.toEpochMilli(LocalDateTime.now());
		return "hello  " + second + " " + milliSecond;
	}

	@GetMapping("hello12")
	public HashMap<@Nullable String, @Nullable Object> hello12() {
		LocalDateTime time = LocalDateTimeUtil.of(System.currentTimeMillis());
		HashMap<@Nullable String, @Nullable Object> map = Maps.newHashMap();
		map.put("hello", null);
		map.put("DateUtil.now", DateUtil.now());
		map.put("LocalDateTime time", time);
		return map;
	}

	@GetMapping("multiField")
	public ModelValidMultField multiField(@Validated ModelValidMultField field) {
		return field;
	}

	@GetMapping("singleParam")
	public String singleParam(@NotEmpty @ICustomerValided String paramOne, @NotEmpty String paramTwo, @NotEmpty String paramThree) {

		return paramOne + " " + paramTwo + " " + paramThree;
	}

	@GetMapping("getMethod")
	public MVCUser getMethod(@Validated(ICustomerGroupGet.class) MVCUser mvcUser) {
		mvcUser.setUserName("CrudGet" + mvcUser.getUserName());
		return mvcUser;
	}

	@PostMapping("postMethod")
	public MVCUser postMethod(@RequestBody @Validated(ICustomerGroupUpdate.class) MVCUser mvcUser) {
		mvcUser.setUserName("CrudPost" + mvcUser.getUserName());
		return mvcUser;
	}

	@PutMapping("putMethod")
	public MVCUser putMethod(@RequestBody MVCUser mvcUser) {
		mvcUser.setUserName("修改之后的username");
		mvcUser.setPassword("修改之后的password");
		mvcUser.setUpdateTime(LocalDateTime.now());
		return mvcUser;
	}

	@DeleteMapping("deleteMethod")
	public MVCUser deleteMethod(@RequestBody MVCUser mvcUser) {
		mvcUser.setUserName("deleted");
		return mvcUser;
	}

	@GetMapping("errorTest")
	public MVCUser errorTest(MVCUser mvcUser) {
		// 抛出自定义异常
		throw new RestfulErrorTest("test exception", mvcUser);
	}
}
