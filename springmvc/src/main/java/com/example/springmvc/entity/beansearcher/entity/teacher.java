package com.example.springmvc.entity.beansearcher.entity;

import java.io.Serializable;

/**
 * (Teacher)ʵ����
 *
 * @author makejava
 * @since 2022-11-24 22:49:15
 */
public class teacher implements Serializable {
	private static final long serialVersionUID = 839392675420057770L;

	private String tId;

	private String tName;


	public String getTId() {
		return tId;
	}

	public void setTId(String tId) {
		this.tId = tId;
	}

	public String getTName() {
		return tName;
	}

	public void setTName(String tName) {
		this.tName = tName;
	}

}

