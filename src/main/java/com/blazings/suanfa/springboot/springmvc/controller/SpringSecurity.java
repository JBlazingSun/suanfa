package com.blazings.suanfa.springboot.springmvc.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("restful")
public class SpringSecurity {
	@GetMapping("hello")
	public ResponseEntity<String> Hello(){
		return ResponseEntity.ok("hello");
	}
}
