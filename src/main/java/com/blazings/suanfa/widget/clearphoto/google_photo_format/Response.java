package com.blazings.suanfa.widget.clearphoto.google_photo_format;

import java.util.List;
import lombok.Data;

@Data
public class Response{
	private PhotoTakenTime photoTakenTime;
	private CreationTime creationTime;
	private String description;
	private GeoDataExif geoDataExif;
	private String title;
	private GeoData geoData;
	private List<PeopleItem> people;
	private String imageViews;
	private String url;
	private PhotoLastModifiedTime photoLastModifiedTime;
	private GooglePhotosOrigin googlePhotosOrigin;
}