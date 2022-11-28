package com.example.springmvc.entity.beansearcher.entity;

import com.ejlchina.searcher.bean.DbField;
import lombok.Data;

import java.io.Serializable;

/**
 * (Student)ʵ����
 *
 * @author makejava
 * @since 2022-11-24 22:49:15
 */
@Data
public class student implements Serializable {
	private static final long serialVersionUID = -27149613179899569L;
	@DbField(value = "s.s_id", alias = "学生ID")
	private String sId;
	@DbField(value = "s.s_name", alias = "学生名字")
	private String sName;
	@DbField(value = "s.s_brith", alias = "学生生日")
	private String sBrith;
	@DbField(value = "s.s_sex", alias = "学生性别")
	private String sSex;


	public String getSId() {
		return sId;
	}

	public void setSId(String sId) {
		this.sId = sId;
	}

	public String getSName() {
		return sName;
	}

	public void setSName(String sName) {
		this.sName = sName;
	}

	public String getSBrith() {
		return sBrith;
	}

	public void setSBrith(String sBrith) {
		this.sBrith = sBrith;
	}

	public String getSSex() {
		return sSex;
	}

	public void setSSex(String sSex) {
		this.sSex = sSex;
	}

}

