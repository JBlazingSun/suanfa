package com.blazings.suanfa.springboot.springmvc.entity;

import com.blazings.suanfa.springboot.springmvc.config.annotation.ICustomerValided;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigInteger;
import java.time.LocalDateTime;

@Data
public class User {
	@NotEmpty
	@ICustomerValided(message = "自定义注解")
	String userName;
	String password;
	LocalDateTime updateTime;
	@NotNull
	@PositiveOrZero()
	BigInteger number;
}
