package com.blazings.suanfa.component.forest.config;

import lombok.Data;

@Data
public class ResultData<T> {
	private int status;
	private String msg;
	private T data;
	private long timestamp;

	public ResultData() {
		this.timestamp = System.currentTimeMillis();
	}

	public static <T> ResultData<T> success(T data) {
		ResultData<T> resultData = new ResultData<>();
		resultData.setStatus(ReturnCode.RC200.getCode());
		resultData.setMsg(ReturnCode.RC200.getMessage());
		resultData.setData(data);
		return resultData;
	}

	public static <T> ResultData<T> fail(int code, String message) {
		ResultData<T> resultData = new ResultData<>();
		resultData.setStatus(code);
		resultData.setMsg(message);
		return resultData;
	}
}