package com.example.nacosprovider.controller;

import com.example.nacosprovider.NacosProviderApplication;
import com.example.nacosprovider.entity.TaobaoTime;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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

		return "provider post-method 参数是 " + getParm + " 时间是  " + System.currentTimeMillis();
	}

	@PostMapping("postObject")
	public String GetObjectParm(@RequestBody TaobaoTime time) throws JsonProcessingException {
		time.setApi("获取到parm, 在server端已修改");
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(time);
	}

	@GetMapping("getConfig")
	public String PublicMethod() {
		String userName = NacosProviderApplication.run.getEnvironment().getProperty("user.name");
		String userAge = NacosProviderApplication.run.getEnvironment().getProperty("user.age");
		return userName+userAge;
	}
}
