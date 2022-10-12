package com.blazings.suanfa.widget.clearphoto;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.file.FileReader;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.blazings.suanfa.widget.clearphoto.google_photo_format.Response;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.*;

import java.io.File;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
@Slf4j
class ImageTest {

	@BeforeEach
	void setUp() {
	}

	@AfterEach
	void tearDown() {
	}

	@Test
	void getSuf() {
		Image image = new Image();
		File file = new File("E:\\download\\Takeout\\Google 相册\\11月二外高中罗邦友聚餐\\IMG_20171115_193830.jpg.json");
		File file1 = new File("E:\\download\\Takeout\\Google 相册\\11月二外高中罗邦友聚餐\\IMG_20171115_193830.jpg");
		File file2 = new File("E:\\download\\Takeout\\Google 相册\\2019元旦上海和欧阳明聚会\\VID_20181230_160658.mp4");

//		assertThat(FileUtil.exist(image.target + "\\5")).isEqualTo(true);
		FileReader fileReader = new FileReader(file);
		String result = fileReader.readString();
	}

	@Test
	void getGooglePhotoFormat() {
		Image image = new Image();
		String googlePhotoFormat = image.getGooglePhotoFormat("E:\\download\\Takeout\\Google 相册\\2015-5-2 外婆綦江80大寿\\PIC_20150503_115631_B38.jpg.json");
		log.info(googlePhotoFormat);
	}
	//三方库
	@Test
	void getImageTime() {
		Image image = new Image();
		File file = new File("E:\\download\\Takeout\\Google 相册\\11月二外高中罗邦友聚餐\\IMG_20171115_193830.jpg");
		image.getImageTime(file);
	}

	@Test
	void getPhotoObject() throws JsonProcessingException {
		Image image = new Image();
		Image mock = mock(Image.class);
		when(mock.getGooglePhotoFormat("")).thenReturn("{\n" +
			"  \"title\": \"IMG_20171115_231934.jpg\",\n" +
			"  \"description\": \"\",\n" +
			"  \"imageViews\": \"12\",\n" +
			"  \"creationTime\": {\n" +
			"    \"timestamp\": \"1510911981\",\n" +
			"    \"formatted\": \"2017年11月17日 UTC 09:46:21\"\n" +
			"  },\n" +
			"  \"photoTakenTime\": {\n" +
			"    \"timestamp\": \"1510759174\",\n" +
			"    \"formatted\": \"2017年11月15日 UTC 15:19:34\"\n" +
			"  },\n" +
			"  \"geoData\": {\n" +
			"    \"latitude\": 29.582452999999997,\n" +
			"    \"longitude\": 106.52823699999999,\n" +
			"    \"altitude\": -0.0,\n" +
			"    \"latitudeSpan\": 0.0,\n" +
			"    \"longitudeSpan\": 0.0\n" +
			"  },\n" +
			"  \"geoDataExif\": {\n" +
			"    \"latitude\": 29.582452999999997,\n" +
			"    \"longitude\": 106.52823699999999,\n" +
			"    \"altitude\": -0.0,\n" +
			"    \"latitudeSpan\": 0.0,\n" +
			"    \"longitudeSpan\": 0.0\n" +
			"  },\n" +
			"  \"people\": [{\n" +
			"    \"name\": \"小矿\"\n" +
			"  }],\n" +
			"  \"url\": \"https://lh3.googleusercontent.com/8L4dVAZSdZOyNI5-ViwBttKFUDUT7NaYeW4noVArhCj7FoDdnviSMvmgOxrWdGmsEr-LUfXME9KF7flHMfLAuw1MnbDrj5z4A-AMNkg\",\n" +
			"  \"googlePhotosOrigin\": {\n" +
			"    \"mobileUpload\": {\n" +
			"      \"deviceFolder\": {\n" +
			"        \"localFolderName\": \"\"\n" +
			"      },\n" +
			"      \"deviceType\": \"ANDROID_PHONE\"\n" +
			"    }\n" +
			"  },\n" +
			"  \"photoLastModifiedTime\": {\n" +
			"    \"timestamp\": \"1660690106\",\n" +
			"    \"formatted\": \"2022年8月16日 UTC 22:48:26\"\n" +
			"  }\n" +
			"}");
		String chinaTime = image.getPhotoTimeStamp(mock.getGooglePhotoFormat("")) + "000";
		DateTime chinaDate = DateUtil.date(Long.parseLong(chinaTime));
		log.info(chinaDate.toString());
		log.info(String.valueOf(chinaDate.year()));
		//月数是从0开始
		log.info(String.valueOf(chinaDate.month()+1));

		String year = String.valueOf(chinaDate.year());
		//月数是从0开始
		String month = String.valueOf(chinaDate.month() + 1);
		//获取文件名
		JSONObject parseObj = JSONUtil.parseObj(mock.getGooglePhotoFormat(""));
		String fileName = parseObj.getStr("title");
		//判断sort文件夹里对应年份月份文件夹是否存在, 不存在就创建
		if (!FileUtil.exist(image.target + "\\"+year+"-"+month)) {
			FileUtil.mkdir(image.target + "\\" + year + "-" + month);
		}

		//判断sort文件夹里对应年份月份文件夹对应的 文件名是否存在, 存在就跳过
		if (!FileUtil.exist(image.target + "\\" + year + "-" + month + "\\" + fileName)) {
			//复制到对应年份月份文件夹
			FileUtil.copy("E:\\download\\Takeout\\Google 相册\\Photos from 2017\\IMG_20171115_231934.jpg", image.target + "\\" + year + "-" + month + "\\" + fileName, true);
		}
	}

	@Test
	void copyFiles() throws JsonProcessingException {
		Image image = new Image();
		image.eachFiles(new File("E:\\download\\Takeout"));
		log.info(image.filesNum +"    文件夹:  "+ image.dirNum);
	}
}