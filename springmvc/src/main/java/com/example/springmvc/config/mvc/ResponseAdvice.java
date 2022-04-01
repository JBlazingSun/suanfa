package com.example.springmvc.config.mvc;

import com.example.springmvc.entity.ResultData;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.util.TreeMap;

@RestControllerAdvice
public class ResponseAdvice implements ResponseBodyAdvice<Object> {
	@Autowired
	private ObjectMapper objectMapper;

	@Override
	public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
		//springdoc
		if (returnType.getExecutable().getName().equals("openapiJson")) {
			return false;
		}
		return true;
	}

	@SneakyThrows
	@Override
	public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
		if (body instanceof String) {
			return objectMapper.writeValueAsString(ResultData.success(body));
		} else if (body instanceof ResultData) {
			return body;
		}
		//springdoc
		else if (body instanceof TreeMap && ((TreeMap<?, ?>) body).containsValue("/v3/api-docs/swagger-config")) {
			return body;
		} else {
			return ResultData.success(body);
		}
	}
}
