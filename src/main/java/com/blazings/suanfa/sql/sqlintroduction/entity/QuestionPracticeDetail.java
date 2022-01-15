package com.blazings.suanfa.sql.sqlintroduction.entity;


import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

/**
 * (QuestionPracticeDetail)表实体类
 *
 * @author makejava
 * @since 2022-01-15 16:57:22
 */
@SuppressWarnings("serial")
public class QuestionPracticeDetail extends Model<QuestionPracticeDetail> {

	private Integer id;

	private Integer deviceId;

	private Integer questionId;

	private String result;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(Integer deviceId) {
		this.deviceId = deviceId;
	}

	public Integer getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Integer questionId) {
		this.questionId = questionId;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

}

