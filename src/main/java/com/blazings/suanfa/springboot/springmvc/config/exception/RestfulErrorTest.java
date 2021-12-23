package com.blazings.suanfa.springboot.springmvc.config.exception;

import com.blazings.suanfa.springboot.springmvc.entity.User;
import lombok.Data;

@Data
public class RestfulErrorTest extends RuntimeException {

	User user;

	public RestfulErrorTest(String message, User user) {
		super(message);
		this.setUser(user);
	}
}