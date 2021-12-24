package com.blazings.suanfa.springboot.springmvc.entity;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigInteger;
import java.time.LocalDateTime;

@Data
public class User {

	String user;
	String password;
	LocalDateTime updateTime;
	@NotNull @PositiveOrZero() BigInteger number;
}
