package com.blazings.mall.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("mall")
public class mall {
	@GetMapping("hello")
	public String PublicMethod() {

		return String.valueOf(System.currentTimeMillis());
	}
}
