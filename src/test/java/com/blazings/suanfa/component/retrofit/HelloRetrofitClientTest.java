package com.blazings.suanfa.component.retrofit;

import com.blazings.suanfa.entity.TaobaoTime;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class HelloRetrofitClientTest {

	@Resource
	HelloRetrofitClient retrofitClient;
	@Test
	void getTime() throws JsonProcessingException {
		String time = retrofitClient.getTime("mtop.common.getTimestamp");
		ObjectMapper objectMapper = new ObjectMapper();
		TaobaoTime taobaoTime = objectMapper.readValue(time, TaobaoTime.class);
		assertThat(taobaoTime.getRet()[0]).isEqualTo("SUCCESS::接口调用成功");
	}
}