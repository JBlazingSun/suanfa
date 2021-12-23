package com.blazings.suanfa.springboot.springmvc.entity;

import lombok.Data;

import java.math.BigInteger;
import java.time.LocalDateTime;

@Data
public class User {
	String user;
	String password;
	LocalDateTime updateTime;
	BigInteger number;
}
