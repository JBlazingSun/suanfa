package com.blazings.suanfa.springboot.springmvc.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

//@Aspect
//@Component
public class RestfulContorllerAop {
	@Around("execution(* com.blazings.suanfa.springboot.springmvc.controller.*(..))")
	public Object RestfulAop(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		System.out.println("RestfulContorllerAop before");

		proceedingJoinPoint.proceed();

		System.out.println("RestfulContorllerAop after");
		return null;
	}
}
