package com.blazings.suanfa.widget.clearphoto;

import cn.hutool.core.io.file.FileReader;
import com.blazings.suanfa.widget.clearphoto.google_photo_format.Response;
import com.drew.imaging.jpeg.JpegMetadataReader;
import com.drew.imaging.jpeg.JpegProcessingException;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.Tag;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

@Slf4j
public class Image {
	public Response getPhotoObject(String fileJson) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		Response response = objectMapper.readValue(fileJson, Response.class);
		return response;
	}


	public String getGooglePhotoFormat(String filepath) {
		FileReader fileReader = new FileReader(filepath);
		String result = fileReader.readString();
		return result;
	}
	
	
	/**
	 * 处理 单张 图片
	 *
	 * @return void
	 * @date 2015-7-25 下午7:30:47
	 */
	public boolean getImageTime(File jpegFile) {
		Metadata metadata;
		try {
			metadata = JpegMetadataReader.readMetadata(jpegFile);
			Iterator<Directory> it = metadata.getDirectories().iterator();
			while (it.hasNext()) {
				Directory exif = it.next();
				Iterator<Tag> tags = exif.getTags().iterator();
				while (tags.hasNext()) {
					Tag tag = (Tag) tags.next();
					log.info(tag.toString());
				}
			}
		} catch (JpegProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
}
