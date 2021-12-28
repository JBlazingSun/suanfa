package com.blazings.suanfa.springboot.springmvc.entity;

import com.blazings.suanfa.springboot.springmvc.config.annotation.MultiField;
import lombok.Data;

import java.time.LocalDateTime;
@Data
@MultiField
public class ModelValidMultField {
	LocalDateTime startTime;
	LocalDateTime endTime;
}
