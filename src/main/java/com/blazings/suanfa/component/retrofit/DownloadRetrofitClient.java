package com.blazings.suanfa.component.retrofit;

import com.github.lianjiatech.retrofit.spring.boot.core.RetrofitClient;
import okhttp3.ResponseBody;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

import java.util.Map;

@RetrofitClient(baseUrl = "${tuna.baseUrl}")
public interface DownloadRetrofitClient {
	@GET("")
	Response<ResponseBody> download(@Url String url, @QueryMap Map<String,String> params);
}
