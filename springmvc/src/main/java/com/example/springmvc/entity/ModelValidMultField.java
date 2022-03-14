package com.example.springmvc.entity;

import com.example.springmvc.config.annotation.MultiField;
import lombok.Data;

import java.time.LocalDateTime;
@Data
@MultiField(message = "endTime结束时间要大于startTime开始时间")
public class ModelValidMultField {
	LocalDateTime startTime;
	LocalDateTime endTime;
}
