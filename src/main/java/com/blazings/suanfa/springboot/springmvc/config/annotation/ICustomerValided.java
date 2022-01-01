package com.blazings.suanfa.springboot.springmvc.config.annotation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * 自定义注解校验
 * @author 32880
 */
@Documented
@Target({ElementType.PARAMETER, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CustomerValid.class)
public @interface ICustomerValided {
	String message() default "自定义注解的参数不正确, 正确是c";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
