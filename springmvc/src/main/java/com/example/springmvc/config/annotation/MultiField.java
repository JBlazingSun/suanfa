package com.example.springmvc.config.annotation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 *
 * @author 32880
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(
	validatedBy = {MultiFieldConstraint.class}
)
public @interface MultiField {
	String message() default "结束时间要大于开始时间";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
