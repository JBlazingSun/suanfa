package com.example.springmvc.entity.beansearcher.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;

/**
 * (Score)ʵ����
 *
 * @author makejava
 * @since 2022-11-24 22:49:15
 */
@Data
public class score implements Serializable {
	private static final long serialVersionUID = -48416428486730758L;

	@TableId("s_id")
	private String sId;

	private String cId;

	private Integer sScore;


	public String getSId() {
		return sId;
	}

	public void setSId(String sId) {
		this.sId = sId;
	}

	public String getCId() {
		return cId;
	}

	public void setCId(String cId) {
		this.cId = cId;
	}

	public Integer getSScore() {
		return sScore;
	}

	public void setSScore(Integer sScore) {
		this.sScore = sScore;
	}

}

