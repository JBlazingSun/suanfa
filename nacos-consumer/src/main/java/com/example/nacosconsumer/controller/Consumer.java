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
@RefreshScope
public class Consumer {
	final Provider provider;

	@GetMapping("get")
	public String getMethod() {
		String consumerGet = provider.Get();
		return consumerGet;
	}

	@GetMapping("getNacosConfigFromProvider")
	public String getNacosConfigFromProvider() {
		String consumerGet = provider.GetNacosConfig();
		return consumerGet+"  from nacos-provider";
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

}
