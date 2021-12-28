package com.blazings.suanfa.springboot.springmvc.config.exception;

import cn.hutool.core.util.StrUtil;
import com.blazings.suanfa.springboot.springmvc.entity.MVCUser;
import com.google.common.collect.Lists;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@RestControllerAdvice
@RequiredArgsConstructor
@Slf4j
public class ControllerAdviceHandler {
	private final HttpServletRequest request;

	@ExceptionHandler(RestfulErrorTest.class)
	@ResponseStatus(HttpStatus.OK)
	public MVCUser RestfulErrorTest(RestfulErrorTest restfulErrorTest) {
		return restfulErrorTest.getMVCUser();
	}

	/**
	 * 统一处理参数校验异常
	 * <pre>
	 * 对象参数接收请求体校验不通过会抛出 MethodArgumentNotValidException
	 * 普通参数校验校验不通过会抛出 ConstraintViolationException
	 * 必填参数没传校验不通过会抛出 ServletRequestBindingException
	 * 请求参数绑定到对象上校验不通过会抛出 BindException
	 * </pre>
	 */
	@ExceptionHandler({ConstraintViolationException.class,
		MethodArgumentNotValidException.class,
		ServletRequestBindingException.class,
		BindException.class})
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ResponseEntity<String> handleValidationException(Exception e) {
		String logMsg = getErrorLogMsg(e);
		String msg = "";
		//对象参数接收请求体校验不通过会抛出 MethodArgumentNotValidException
		if (e instanceof MethodArgumentNotValidException) {
			MethodArgumentNotValidException t = (MethodArgumentNotValidException) e;
			msg = getBindingResultMsg(t.getBindingResult());
			//请求参数绑定到对象上校验不通过会抛出 BindException
		} else if (e instanceof BindException) {
			BindException t = (BindException) e;
			msg = getBindingResultMsg(t.getBindingResult());
			//普通参数校验校验不通过会抛出 ConstraintViolationException
		} else if (e instanceof ConstraintViolationException) {
			msg = getConstraintViolationExceptionMsg((ConstraintViolationException) e);
		} else if (e instanceof MissingServletRequestParameterException) {
			MissingServletRequestParameterException t = (MissingServletRequestParameterException) e;
			msg = t.getParameterName() + " 不能为空";
		} else if (e instanceof MissingPathVariableException) {
			MissingPathVariableException t = (MissingPathVariableException) e;
			msg = t.getVariableName() + " 不能为空";
		} else {
			// 其他类型的错误当成未知异常处理
			return handleUnknownException(e);
		}
//		log.warn("参数校验不通过, {}, msg: {}", logMsg, msg);
		return ResponseEntity.ok(msg);
	}
	private String getConstraintViolationExceptionMsg(ConstraintViolationException e) {
		ArrayList<@Nullable String> errorList = Lists.newArrayList();
		e.getConstraintViolations().forEach(c -> {
			errorList.add(c.getPropertyPath()+c.getMessage());
		});
		return errorList.stream()
			.map(Object::toString)
			.collect(Collectors.joining(","));
	}

	private String getBindingResultMsg(BindingResult result) {
		ArrayList<@Nullable String> errorList = Lists.newArrayList();
		result.getAllErrors().forEach(objectError -> {
			FieldError fieldError = (FieldError) objectError;
			errorList.add(fieldError.getField() + objectError.getDefaultMessage());
		});
		return errorList.stream()
			.map(Object::toString)
			.collect(Collectors.joining(","));
	}
	/**
	 * 统一处理未知异常
	 *
	 * @return
	 */
	@ExceptionHandler
	public ResponseEntity<String> handleUnknownException(Throwable t) {
		String logMsg = getErrorLogMsg(t);
//		log.error("捕获到未经处理的未知异常, {}", logMsg, t);
		return ResponseEntity.ok(logMsg);
	}
	/**
	 * 异常信息应包含 url + queryString(若有) + 请求参数(这里只能拿到表单提交的参数) + username(若有)
	 */
	private String getErrorLogMsg(Throwable t) {
		StringBuilder errorLogMsg = new StringBuilder();
		// url，包括查询 queryString
		errorLogMsg.append("url: ").append(request.getRequestURL().toString());
		if (StrUtil.isNotBlank(request.getQueryString())) {
			errorLogMsg.append("?").append(request.getQueryString());
		}
		// 获取参数，这里只能拿到查询参数和以表单形式提交的参数，requestBody 的拿不到
		Map<String, String[]> params = request.getParameterMap();
		if (params != null && !params.isEmpty()) {
			StringBuilder builder = new StringBuilder();
			params.forEach((k, v) -> {
				builder.append(",").append(k).append("=").append(Arrays.toString(v));
			});
			errorLogMsg.append(", params:").append(builder.substring(1));
		}
		// 如果能获取到当前登录人信息，则添加到最前面
		String username = getUsername();
		if (StrUtil.isNotBlank(username)) {
			errorLogMsg.insert(0, "username: " + username + ", ");
		}
		return errorLogMsg.toString();
	}

	private String getUsername() {
		// 尝试拿当前登录人的 principal
		return Optional.ofNullable(request.getUserPrincipal())
			.map(Principal::getName)
			.orElse("");
	}
//	/**
//	 * 处理浏览器的 html 直接请求
//	 */
//	@RequestMapping(produces = "text/html")
//	public String errorHtml() {
//		String msg = Objects.toString(request.getAttribute("msg"), "出错啦");
//		request.setAttribute("msg", msg);
//		return "error";
//	}
//
//	/**
//	 * 其他请求则以 response body 的形式返回
//	 */
//	@ResponseBody
//	@RequestMapping
//	public ResponseEntity<String> error() {
//		String msg = Objects.toString(request.getAttribute("msg"), "出错啦");
//		String code = Objects.toString(request.getAttribute("code"), null);
//		// 如果有指定 code，则按 code 返回
//		if (StrUtil.isNumeric(code)) {
//			return ResponseEntity.ok(code+"  "+msg);
//		} else {
//			// 否则视为未知异常
//			return ResponseEntity.ok(code+"  "+msg);
//		}
//	}
}
