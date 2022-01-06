package com.blazings.suanfa.component.forest.controller;

import com.blazings.suanfa.springboot.springmvc.entity.ResultData;
import com.dtflys.forest.Forest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
@Slf4j
@RequestMapping("forest")
public class Test {
	@GetMapping("restfulHello")
	public ResultData restfulHello() {
		ResultData r = Forest.get("/restful/hello").port(8080).execute(ResultData.class);
		return r;
	}
}
