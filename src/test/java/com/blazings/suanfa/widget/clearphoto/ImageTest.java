package com.blazings.suanfa.widget.clearphoto;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;
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
	void getImageTime() {
		Image image = new Image();
		File file = new File("E:\\download\\Takeout\\Google 相册\\11月二外高中罗邦友聚餐\\IMG_20171115_193830.jpg");
		image.getImageTime(file);
	}

	@Test
	void getGooglePhotoFormat() {
		Image image = new Image();
		String googlePhotoFormat = image.getGooglePhotoFormat("E:\\download\\Takeout\\Google 相册\\2015-5-2 外婆綦江80大寿\\PIC_20150503_115631_B38.jpg.json");
		log.info(googlePhotoFormat);
	}
}