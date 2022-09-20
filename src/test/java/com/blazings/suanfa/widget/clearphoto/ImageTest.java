package com.blazings.suanfa.widget.clearphoto;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.FileTypeUtil;
import cn.hutool.core.io.FileUtil;
import com.blazings.suanfa.widget.clearphoto.google_photo_format.Response;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.mockito.Mockito.*;

import java.io.File;

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
	void getGooglePhotoFormat() {
		Image image = new Image();
		String googlePhotoFormat = image.getGooglePhotoFormat("E:\\download\\Takeout\\Google 相册\\2015-5-2 外婆綦江80大寿\\PIC_20150503_115631_B38.jpg.json");
		log.info(googlePhotoFormat);
	}
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
			"  \"title\": \"PIC_20150503_115631_B38.jpg\",\n" +
			"  \"description\": \"\",\n" +
			"  \"imageViews\": \"2\",\n" +
			"  \"creationTime\": {\n" +
			"    \"timestamp\": \"1492834131\",\n" +
			"    \"formatted\": \"2017年4月22日 UTC 04:08:51\"\n" +
			"  },\n" +
			"  \"photoTakenTime\": {\n" +
			"    \"timestamp\": \"1430625391\",\n" +
			"    \"formatted\": \"2015年5月3日 UTC 03:56:31\"\n" +
			"  },\n" +
			"  \"geoData\": {\n" +
			"    \"latitude\": 28.980130600000003,\n" +
			"    \"longitude\": 106.6603167,\n" +
			"    \"altitude\": 348.655737704918,\n" +
			"    \"latitudeSpan\": 0.0,\n" +
			"    \"longitudeSpan\": 0.0\n" +
			"  },\n" +
			"  \"geoDataExif\": {\n" +
			"    \"latitude\": 28.980130600000003,\n" +
			"    \"longitude\": 106.6603167,\n" +
			"    \"altitude\": 348.655737704918,\n" +
			"    \"latitudeSpan\": 0.0,\n" +
			"    \"longitudeSpan\": 0.0\n" +
			"  },\n" +
			"  \"url\": \"https://lh3.googleusercontent.com/MI3xw_aWscweMCxhE2ewWiCemLU2nX3tuZiMDb-_TaLZjW7DYyki_pICm7s-9wd9EDhlZqDC-2QCsEest1FpEoEWy5lpcgo_HokBtGg\",\n" +
			"  \"googlePhotosOrigin\": {\n" +
			"    \"webUpload\": {\n" +
			"      \"computerUpload\": {\n" +
			"      }\n" +
			"    }\n" +
			"  },\n" +
			"  \"photoLastModifiedTime\": {\n" +
			"    \"timestamp\": \"1660219963\",\n" +
			"    \"formatted\": \"2022年8月11日 UTC 12:12:43\"\n" +
			"  }\n" +
			"}");
		Response photoObject = image.getPhotoObject(mock.getGooglePhotoFormat(""));
		String chinaTime = photoObject.getPhotoTakenTime().getTimestamp() + "000";
		DateTime chinaDate = DateUtil.date(Long.parseLong(chinaTime));
		log.info(chinaDate.toString());
		log.info(String.valueOf(chinaDate.year()));
		//月数是从0开始
		log.info(String.valueOf(chinaDate.month()+1));
	}

	@Test
	void printFiles() {
		Image image = new Image();
		image.eachFiles(new File("E:\\download\\Takeout"));
		log.info(String.valueOf(image.filesNum)+"    文件夹:  "+String.valueOf(image.dirNum));
	}
}