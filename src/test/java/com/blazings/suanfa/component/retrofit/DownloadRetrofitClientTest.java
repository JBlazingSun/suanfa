package com.blazings.suanfa.component.retrofit;

import okhttp3.ResponseBody;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import retrofit2.Response;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

@SpringBootTest
class DownloadRetrofitClientTest {
	@Resource
	DownloadRetrofitClient downloadRetrofitClient;

	@Test
	void download() throws IOException {
		Response<ResponseBody> response = downloadRetrofitClient.download("4276151928,2257626089&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=313");
		ResponseBody responseBody = response.body();
		// 二进制流
		InputStream is = responseBody.byteStream();

		// 具体如何处理二进制流，由业务自行控制。这里以写入文件为例
		File tempDirectory = new File("E:\\download");
		if (!tempDirectory.exists()) {
			tempDirectory.mkdir();
		}
		File file = new File(tempDirectory, UUID.randomUUID().toString());
		if (!file.exists()) {
			file.createNewFile();
		}
		FileOutputStream fos = new FileOutputStream(file);
		byte[] b = new byte[1024];
		int length;
		while ((length = is.read(b)) > 0) {
			fos.write(b, 0, length);
		}
		is.close();
		fos.close();
	}
}