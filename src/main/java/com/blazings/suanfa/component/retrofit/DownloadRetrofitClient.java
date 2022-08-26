package com.blazings.suanfa.component.retrofit;

import com.github.lianjiatech.retrofit.spring.boot.core.RetrofitClient;
import okhttp3.ResponseBody;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

import java.util.Map;

@RetrofitClient(baseUrl = "${tuna.baseUrl}")
public interface DownloadRetrofitClient {
	@GET("it/u=4276151928,2257626089&fm=253&fmt=auto&app=138&f=JPEG")
	Response<ResponseBody> download(@QueryMap Map<String,String> params);
}
