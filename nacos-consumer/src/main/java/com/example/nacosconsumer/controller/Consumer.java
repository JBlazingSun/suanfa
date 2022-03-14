package com.example.nacosconsumer.controller;

import com.example.nacosconsumer.feign.Provider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("consumer")
public class Consumer {
	@Autowired
	Provider provider;

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
}
