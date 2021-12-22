package com.blazings.suanfa.springboot.springmvc.config.exception;

public class RestfulErrorTest extends RuntimeException{

	private static final long serialVersionUID = 860294146204917253L;

	public RestfulErrorTest(String message) {
		super(message);
	}
}
