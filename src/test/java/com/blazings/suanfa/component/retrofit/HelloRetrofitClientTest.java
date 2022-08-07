package com.blazings.suanfa.component.retrofit;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class HelloRetrofitClientTest {

	@Resource
	HelloRetrofitClient retrofitClient;
	@Test
	void getTime() {
		retrofitClient.getTime("mtop.common.getTimestamp");
	}
}