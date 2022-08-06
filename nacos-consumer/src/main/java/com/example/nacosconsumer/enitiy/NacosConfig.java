package com.example.nacosconsumer.enitiy;

import lombok.Data;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@Data
public class NacosConfig {
	String name;
	int age;
}
