package com.blazings.suanfa.component.retrofit;

import com.blazings.suanfa.config.retrofit.Sign;
import com.blazings.suanfa.entity.TaobaoTime;
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
//@Intercept(handler = TimeStampInterceptor.class, include = {"/api/**"},exclude = "/api/test/savePerson")
//@Intercept(handler = TimeStampInterceptor.class,exclude = "/rest/**" )
@Sign(accessKeyId = "${taobao.accessKeyId}",accessKeySecret = "${taobao.accessKeySecret}",exclude = "/api/test/savePerson")
public interface HelloRetrofitClient {
	@GET("api3.do")
	TaobaoTime getTime(@Query("api") String api);
}