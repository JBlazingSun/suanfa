package com.example.springmvc.entity.beansearcher.entity;

import java.io.Serializable;

/**
 * (Course)ʵ����
 *
 * @author makejava
 * @since 2022-11-24 22:49:15
 */
public class course implements Serializable {
	private static final long serialVersionUID = -52386699628388451L;

	private String cId;

	private String cName;

	private String tId;


	public String getCId() {
		return cId;
	}

	public void setCId(String cId) {
		this.cId = cId;
	}

	public String getCName() {
		return cName;
	}

	public void setCName(String cName) {
		this.cName = cName;
	}

	public String getTId() {
		return tId;
	}

	public void setTId(String tId) {
		this.tId = tId;
	}

}

