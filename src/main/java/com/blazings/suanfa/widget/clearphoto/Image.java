package com.blazings.suanfa.widget.clearphoto;

import cn.hutool.core.io.FileUtil;
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

	//用了hutool
	//文件数量
	int filesNum = 0;
	//文件夹数量
	int dirNum = 0;

	//遍历文件夹下所有文件
	public void eachFiles(File dir) {
		if (dir.isDirectory()) {
			//File的listFiles()方法返回File对象的数组，其中包含了当前目录下的子文件和子文件夹结构
			//创建一个File类型的数组 next[]来接收返回值
			File next[] = dir.listFiles();
			//使用for循环来遍历当前的数组
			for (int i = 0; i < next.length; i++) {
				//无论当前的文件是文件还是文件夹，都输出其名称 getName()
				//				System.out.println(next[i].getName());
				if (FileUtil.isFile(next[i])) {
					filesNum++;
				}
				if (FileUtil.isDirectory(next[i])) {
					dirNum++;
				}
				//如果是文件夹，需要再列出其下一级的所有的元素（内部的结构）
				if (next[i].isDirectory()) {
					//循环调用，且下一级文件结构要多缩进一个即 tab+1
					eachFiles(next[i]);
				}
			}
		}
	}


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
