package com.blazings.suanfa.sql.sqlintroduction.entity;


import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

/**
 * (UserProfile)表实体类
 *
 * @author makejava
 * @since 2022-01-15 16:57:51
 */
@SuppressWarnings("serial")
public class UserProfile extends Model<UserProfile> {

	private Integer id;

	private Integer deviceId;

	private String gender;

	private Integer age;

	private String university;

	private Float gpa;

	private Integer activeDaysWithin30;

	private Integer questionCnt;

	private Integer answerCnt;


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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getUniversity() {
		return university;
	}

	public void setUniversity(String university) {
		this.university = university;
	}

	public Float getGpa() {
		return gpa;
	}

	public void setGpa(Float gpa) {
		this.gpa = gpa;
	}

	public Integer getActiveDaysWithin30() {
		return activeDaysWithin30;
	}

	public void setActiveDaysWithin30(Integer activeDaysWithin30) {
		this.activeDaysWithin30 = activeDaysWithin30;
	}

	public Integer getQuestionCnt() {
		return questionCnt;
	}

	public void setQuestionCnt(Integer questionCnt) {
		this.questionCnt = questionCnt;
	}

	public Integer getAnswerCnt() {
		return answerCnt;
	}

	public void setAnswerCnt(Integer answerCnt) {
		this.answerCnt = answerCnt;
	}

}

