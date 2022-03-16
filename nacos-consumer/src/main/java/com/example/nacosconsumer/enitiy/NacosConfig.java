package com.example.nacosconsumer.enitiy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@RefreshScope
public class NacosConfig {
	@Value("${user.name}")
	String name;
	@Value(("${user.age}"))
	int age;
}
