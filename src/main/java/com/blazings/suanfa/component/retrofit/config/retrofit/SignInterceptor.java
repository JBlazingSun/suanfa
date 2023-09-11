package com.blazings.suanfa.component.retrofit.config.retrofit;

import com.github.lianjiatech.retrofit.spring.boot.interceptor.BasePathMatchInterceptor;
import lombok.Data;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.stereotype.Component;

import java.io.IOException;
@Component
@Data
public class SignInterceptor extends BasePathMatchInterceptor {

	private String accessKeyId;

	private String accessKeySecret;

	public void setAccessKeyId(String accessKeyId) {
		this.accessKeyId = accessKeyId;
	}

	public void setAccessKeySecret(String accessKeySecret) {
		this.accessKeySecret = accessKeySecret;
	}

	@Override
	protected Response doIntercept(Chain chain) throws IOException {
		Request build = chain.request()
			.newBuilder()
			.addHeader("accessKeyId", accessKeyId)
			.addHeader("accessKeySecret", accessKeySecret)
			.build();
		return chain.proceed(build);
	}
}
