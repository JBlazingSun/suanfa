package com.example.nacosprovider.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("provider")
public class NacosProviderCtrl {
	@GetMapping("method")
	public String ProviderMethod(String getParm) {

		return "参数是 " + getParm +" 时间是  " +System.currentTimeMillis();
	}
}
