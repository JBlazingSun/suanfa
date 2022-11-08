package com.example.springmvc.config.mvc;

import com.example.springmvc.config.annotation.IgnoreResponseAdvice;
import com.example.springmvc.entity.ResultData;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@RestControllerAdvice
public class ResponseAdvice implements ResponseBodyAdvice<Object> {
	private final ObjectMapper objectMapper;
	private static final String V_3_API_DOCS = "/v3/api-docs";
//	private static final String SWAGGER_RESOURCES = "/swagger-resources";
	private static final String ADMIN_ACTUATOR = "/actuator";
	private static final String prometheus = "/actuator/prometheus";
	public ResponseAdvice(ObjectMapper objectMapper) {
		this.objectMapper = objectMapper;
	}

	@Override
	public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
		//不封装springdoc
		if (returnType.getExecutable().getName().equals("openapiJson")) {
			return false;
		}
		// 如果当前方法所在的类标识了 IgnoreResponseAdvice 注解, 则不需要处理
		if (returnType.getDeclaringClass().isAnnotationPresent(IgnoreResponseAdvice.class)) {
			return false;
		}
		// 如果当前方法标识了 IgnoreResponseAdvice 注解, 则不需要处理
		if(returnType.getMethod().isAnnotationPresent(IgnoreResponseAdvice.class)) {
			return false;
		}
		return true;
	}

	@SneakyThrows
	@Override
	public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
		if (body instanceof ResultData) {
			return body;
		}
//		else if (((ServletServerHttpRequest) request).getServletRequest().getRequestURI().equals(V_3_API_DOCS)) {
//			return body;
//		}
//		else if (((ServletServerHttpRequest) request).getServletRequest().getRequestURI().contains(SWAGGER_RESOURCES)) {
//			return body;
//		}
		//不封装actuator
		else if (((ServletServerHttpRequest) request).getServletRequest().getRequestURI().contains(ADMIN_ACTUATOR)) {
			return body;
		}
//		else if (((ServletServerHttpRequest) request).getServletRequest().getRequestURL().toString().contains(prometheus)) {
//			return body;
//		}
		//放后面为了判断Prometheus
		else if (body instanceof String) {
			return objectMapper.writeValueAsString(ResultData.success(body));
		}
		else {
			return ResultData.success(body);
		}
	}
}
