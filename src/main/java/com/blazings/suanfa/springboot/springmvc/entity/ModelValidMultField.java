package com.blazings.suanfa.springboot.springmvc.entity;

import com.blazings.suanfa.springboot.springmvc.config.annotation.MultiField;
import lombok.Data;

import java.time.LocalDateTime;
@Data
@MultiField(message = "endTime结束时间要大于startTime开始时间")
public class ModelValidMultField {
	LocalDateTime startTime;
	LocalDateTime endTime;
}
