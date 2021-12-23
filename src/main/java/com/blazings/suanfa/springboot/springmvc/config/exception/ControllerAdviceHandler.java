package com.blazings.suanfa.springboot.springmvc.config.exception;

import com.blazings.suanfa.springboot.springmvc.entity.User;
import com.google.common.collect.Maps;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ControllerAdviceHandler {

	@ExceptionHandler(RestfulErrorTest.class)
	@ResponseStatus(HttpStatus.OK)
	public User RestfulErrorTest(RestfulErrorTest restfulErrorTest) {

		return restfulErrorTest.getUser();
	}
}
