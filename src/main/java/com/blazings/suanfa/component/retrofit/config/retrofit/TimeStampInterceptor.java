package com.blazings.suanfa.component.retrofit.config.retrofit;

import com.github.lianjiatech.retrofit.spring.boot.interceptor.BasePathMatchInterceptor;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class TimeStampInterceptor extends BasePathMatchInterceptor {
	@Override
	protected Response doIntercept(Chain chain) throws IOException {
		long millis = System.currentTimeMillis();

		HttpUrl timestamp = chain
			.request()
			.url()
			.newBuilder()
			.addQueryParameter("timestamp", String.valueOf(millis))
			.build();

		Request build = chain
			.request()
			.newBuilder()
			.url(timestamp)
			.build();
		return chain.proceed(build);
	}
}
