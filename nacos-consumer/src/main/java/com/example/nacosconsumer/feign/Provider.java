package com.example.nacosconsumer.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("nacos-provider")
public interface Provider {
	@GetMapping("provider/method")
	public String ProviderMethod(String getParm);
}
