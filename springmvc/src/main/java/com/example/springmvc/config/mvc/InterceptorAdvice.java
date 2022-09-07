package com.example.springmvc.config.mvc;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//@Configuration
@Slf4j
public class InterceptorAdvice implements HandlerInterceptor {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		log.info("InterceptorAdvice-preHandle");
		request.setAttribute("InterceptorAdvice-preHandleJ","preHandleJ");
		return HandlerInterceptor.super.preHandle(request, response, handler);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
		log.info("InterceptorAdvice-afterCompletion");
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}
}
