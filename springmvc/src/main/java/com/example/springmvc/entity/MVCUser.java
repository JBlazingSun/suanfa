package com.example.springmvc.entity;

import com.example.springmvc.config.annotation.ICustomerGroupGet;
import com.example.springmvc.config.annotation.ICustomerGroupUpdate;
import com.example.springmvc.config.annotation.ICustomerValided;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.math.BigInteger;
import java.time.LocalDateTime;

@Data
public class MVCUser {
	@NotEmpty(groups = ICustomerGroupGet.class)
	@ICustomerValided(message = "userName自定义注解,正确为c",groups = ICustomerGroupGet.class)
	@Length(min = 3, groups = ICustomerGroupUpdate.class)
	String userName;
	String password;
	LocalDateTime updateTime;
	@NotNull(message = "number不能为空")
	@PositiveOrZero()
	BigInteger number;
}
