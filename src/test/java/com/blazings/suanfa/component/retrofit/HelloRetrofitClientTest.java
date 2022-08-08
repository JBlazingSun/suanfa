package com.blazings.suanfa.component.retrofit;

import com.blazings.suanfa.entity.TaobaoTime;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.*;

import javax.annotation.Resource;

@SpringBootTest
class HelloRetrofitClientTest {

	@Resource
	HelloRetrofitClient retrofitClient;
	@Test
	void getTime() throws JsonProcessingException {
		String time = retrofitClient.getTime("mtop.common.getTimestamp");
		ObjectMapper objectMapper = new ObjectMapper();
		TaobaoTime taobaoTime = objectMapper.readValue(time, TaobaoTime.class);
		assertThat(taobaoTime.getRet()).isEqualTo("[SUCCESS::接口调用成功]");
	}
}