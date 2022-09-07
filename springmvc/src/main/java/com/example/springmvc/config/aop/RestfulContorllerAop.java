package com.example.springmvc.config.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;

//@Aspect
//@Configuration
@Slf4j
public class RestfulContorllerAop {
	/**
	 * class 下的所有方法
	 *
	 * @param proceedingJoinPoint
	 * @return
	 * @throws Throwable
	 */
	@Around("execution(* com.example.springmvc.controller.RestfulController..*(..))")
	public Object RestfulAop(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		log.info("RestfulContorllerAop before " + proceedingJoinPoint.getSignature().getName());

		for (Object arg : proceedingJoinPoint.getArgs()) {
			System.out.println(arg);
		}

		Object proceed = proceedingJoinPoint.proceed();

		log.info("RestfulContorllerAop after " + proceedingJoinPoint.getSignature().getName());
		return proceed;
	}
	public String getString() {

		return "";
	}

}
