package com.blazings.suanfa.springboot.springmvc.config.annotation;

import cn.hutool.core.date.LocalDateTimeUtil;
import com.blazings.suanfa.springboot.springmvc.entity.ModelValidMultField;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MultiFieldConstraint implements ConstraintValidator<MultiField,Object> {
	ModelValidMultField modelValidMultField;
	@Override
	public void initialize(MultiField constraintAnnotation) {
		ConstraintValidator.super.initialize(constraintAnnotation);
	}

	@Override
	public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
		modelValidMultField = (ModelValidMultField) o;
		if (LocalDateTimeUtil.toEpochMilli(modelValidMultField.getEndTime()) - LocalDateTimeUtil.toEpochMilli(modelValidMultField.getStartTime()) > 0) {
			return true;
		}
		return false;
	}
}
