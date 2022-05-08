package com.example.nacosprovider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@EnableDiscoveryClient
public class NacosProviderApplication {

	public static ConfigurableApplicationContext run;
	public static void main(String[] args) {
		run = SpringApplication.run(NacosProviderApplication.class, args);

	}

}
