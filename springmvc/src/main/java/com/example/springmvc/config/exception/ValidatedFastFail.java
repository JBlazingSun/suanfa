package com.example.springmvc.config.exception;

import org.hibernate.validator.HibernateValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

@Configuration
public class ValidatedFastFail {
	@Bean
	public Validator validator() {
		ValidatorFactory validatorFactory = Validation.byProvider(HibernateValidator.class)
			.configure()
			// 快速失败模式
			.failFast(true)
			.buildValidatorFactory();
		return validatorFactory.getValidator();
	}
}
