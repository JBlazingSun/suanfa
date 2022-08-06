package com.example.nacosconsumer.feign;

import com.example.nacosconsumer.enitiy.TaobaoTime;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("nacos-provider")
public interface Provider {
	@GetMapping("provider/get")
	public String Get();

	@PostMapping("provider/post")
	public String Post(@RequestParam("getParm") String getParm);

	@PostMapping("provider/postObject")
	public String GetObjectParm(@RequestBody TaobaoTime time);
	@GetMapping("provider/getConfig")
	public String GetNacosConfig();
}
