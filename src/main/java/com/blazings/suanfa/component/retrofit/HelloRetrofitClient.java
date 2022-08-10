package com.blazings.suanfa.component.retrofit;

import com.github.lianjiatech.retrofit.spring.boot.core.RetrofitClient;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * taobao:
 *   baseUrl: http://api.m.taobao.com/rest/
 *
 * #taobao time api
 * #http://api.m.taobao.com/rest/api3.do?api=mtop.common.getTimestamp
 */
@RetrofitClient(baseUrl = "${taobao.baseUrl}")
public interface HelloRetrofitClient {
	@GET("api3.do")
	String getTime(@Query("api") String api);
}