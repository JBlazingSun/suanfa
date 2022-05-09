package com.example.nacosprovider.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@RefreshScope
public class ConfigNacos {
	@Value("${user.name}")
	String userName;
	@Value("${user.age}")
	String age;
}
