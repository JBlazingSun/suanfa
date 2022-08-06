package com.example.nacosprovider.controller;

import com.example.nacosprovider.NacosProviderApplication;
import com.example.nacosprovider.entity.NacosConfig;
import com.example.nacosprovider.entity.TaobaoTime;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("provider")
@RefreshScope
public class NacosProviderCtrl {
	@Value("${config.name}")
	String name;
	@Value(("${config.age}"))
	int age;
	@GetMapping("get")
	public String PublicMethodGet() {

		return "provider get-method " + System.currentTimeMillis();
	}

	@PostMapping("post")
	public String ProviderMethod(@RequestParam String getParm) {

		return "provider post-method 参数是 " + getParm + " 时间是  " + System.currentTimeMillis();
	}

	@PostMapping("postObject")
	public String GetObjectParm(@RequestBody TaobaoTime time) throws JsonProcessingException {
		time.setApi("获取到parm, 在server端已修改");
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(time);
	}

	@GetMapping("getConfig")
	public NacosConfig GetConfig() {
		NacosConfig config = new NacosConfig();
		config.setName(name);
		config.setAge(age);

		return config;
	}
}
