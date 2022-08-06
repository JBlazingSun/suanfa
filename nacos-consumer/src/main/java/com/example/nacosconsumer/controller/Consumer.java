package com.example.nacosconsumer.controller;

import com.example.nacosconsumer.enitiy.NacosConfig;
import com.example.nacosconsumer.enitiy.TaobaoTime;
import com.example.nacosconsumer.feign.Provider;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("consumer")
@RequiredArgsConstructor
//@RefreshScope
public class Consumer {
	final Provider provider;
	@Value("${config.name}")
	String name;
	@Value(("${config.age}"))
	int age;

	@GetMapping("get")
	public String GetMethod() {
		String consumerGet = provider.Get();
		return consumerGet;
	}

	@PostMapping("post")
	public String PostMethod() {
		String post = provider.Post("我是consumer post");
		return post;
	}

	@PostMapping("postObject")
	public String PostObjectMethod(@RequestBody TaobaoTime time) {
		String parm = provider.GetObjectParm(time);
		return parm;
	}

	@GetMapping("getConfig")
	public NacosConfig GetConfig() {
		NacosConfig config = new NacosConfig();
		config.setName(name);
		config.setAge(age);

		return config;
	}
}
