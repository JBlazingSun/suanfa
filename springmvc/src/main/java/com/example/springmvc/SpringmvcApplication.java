package com.example.springmvc;

import cn.dev33.satoken.quick.SaQuickManager;
import cn.dev33.satoken.quick.config.SaQuickConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class SpringmvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringmvcApplication.class, args);
		SaQuickConfig config = SaQuickManager.getConfig();
		log.info(String.valueOf(""));
	}

}
