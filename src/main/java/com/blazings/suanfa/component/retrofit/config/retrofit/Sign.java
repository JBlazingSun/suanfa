package com.blazings.suanfa.component.retrofit.config.retrofit;

import com.github.lianjiatech.retrofit.spring.boot.interceptor.BasePathMatchInterceptor;
import com.github.lianjiatech.retrofit.spring.boot.interceptor.InterceptMark;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@InterceptMark
public @interface Sign {
	String accessKeyId();

	String accessKeySecret();

	String[] include() default {"/**"};

	String[] exclude() default {};

	Class<? extends BasePathMatchInterceptor> handler() default SignInterceptor.class;
}
