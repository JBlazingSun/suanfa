package com.example.springmvc.entity;

import com.example.springmvc.config.annotation.ICustomerValided;
import com.example.springmvc.config.annotation.ICustomerGroupGet;
import com.example.springmvc.config.annotation.ICustomerGroupUpdate;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
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
