package com.example.springmvc;

import cn.dev33.satoken.quick.SaQuickManager;
import cn.dev33.satoken.quick.config.SaQuickConfig;
import io.micrometer.core.instrument.MeterRegistry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.metrics.MeterRegistryCustomizer;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@Slf4j
public class SpringmvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringmvcApplication.class, args);
		SaQuickConfig config = SaQuickManager.getConfig();
		log.info(String.valueOf(config));
	}

	@Bean
	MeterRegistryCustomizer<MeterRegistry> getConfig(@Value("${spring.application.name}") String appName) {
		return (registry -> registry.config().commonTags("application",appName));
	}

}
