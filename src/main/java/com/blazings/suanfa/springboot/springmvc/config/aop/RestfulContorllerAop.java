package com.blazings.suanfa.springboot.springmvc.config.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class RestfulContorllerAop {
	/**
	 * class 下的所有方法
	 *
	 * @param proceedingJoinPoint
	 * @return
	 * @throws Throwable
	 */
	@Around("execution(* com.blazings.suanfa.springboot.springmvc.controller.RestfulController..*(..))")
	public Object RestfulAop(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		System.out.println(
			"RestfulContorllerAop before " + proceedingJoinPoint.getSignature().getName());

		for (Object arg : proceedingJoinPoint.getArgs()) {
			System.out.println(arg);
		}

		Object proceed = proceedingJoinPoint.proceed();

		System.out.println(
			"RestfulContorllerAop after " + proceedingJoinPoint.getSignature().getName());
		return proceed;
	}
}
