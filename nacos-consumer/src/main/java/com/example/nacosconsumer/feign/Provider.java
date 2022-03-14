package com.example.nacosconsumer.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("nacos-provider")
public interface Provider {
	@GetMapping("provider/get")
	public String Get();

	@PostMapping("provider/post")
	public String Post(@RequestParam("getParm") String getParm);
}
