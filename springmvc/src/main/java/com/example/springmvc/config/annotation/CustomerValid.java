package com.example.springmvc.config.annotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

/**
 * 实现ConstraintValidator就是Spring的bean了, 不需要再加@Configuration
 *
 * @author 32880
 */
public class CustomerValid implements ConstraintValidator<ICustomerValided, Object> {

	@Override
	public void initialize(ICustomerValided constraintAnnotation) {
		ConstraintValidator.super.initialize(constraintAnnotation);
	}

	@Override
	public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
		if (o.equals("c")) {
			return true;
		}
		return false;
	}
}
