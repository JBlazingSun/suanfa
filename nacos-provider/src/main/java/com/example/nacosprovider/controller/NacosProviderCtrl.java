package com.example.nacosprovider.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("provider")
public class NacosProviderCtrl {

	@GetMapping("get")
	public String PublicMethodGet() {

		return "provider get-method " + System.currentTimeMillis();
	}

	@PostMapping("post")
	public String ProviderMethod(@RequestParam String getParm) {

		return "provider post-method 参数是 " + getParm +" 时间是  " +System.currentTimeMillis();
	}
}
