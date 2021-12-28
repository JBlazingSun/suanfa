package com.blazings.suanfa.springboot.springmvc.config.exception;

import com.blazings.suanfa.springboot.springmvc.entity.MVCUser;
import lombok.Data;

@Data
public class RestfulErrorTest extends RuntimeException {

	MVCUser MVCUser;

	public RestfulErrorTest(String message, MVCUser MVCUser) {
		super(message);
		this.setMVCUser(MVCUser);
	}
}