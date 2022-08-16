package com.blazings.suanfa.entity;

import lombok.Value;

@Value
public class Alarm{
	String alarmType;
	String alarmContent;
	String alarmLevel;
}