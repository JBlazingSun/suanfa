package com.example.springmvc.exception;

import com.example.springmvc.entity.MVCUser;
import lombok.Data;

@Data
public class RestfulErrorTest extends RuntimeException {

	MVCUser MVCUser;

	public RestfulErrorTest(String message, MVCUser MVCUser) {
		super(message);
		this.setMVCUser(MVCUser);
	}
}