package com.example.springmvc.config.mybatisplus;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DruidConfiguration {
	public class configuration {
		@Bean
		public ServletRegistrationBean DruidStatViewServlet() {
			System.out.println("servletRegistrationBean configure start.");
			//org.springframework.boot.context.embedded.ServletRegistrationBean提供类的进行注册.
			ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
			servletRegistrationBean.addInitParameter("loginUsername", "a");
			servletRegistrationBean.addInitParameter("loginPassword", "a");
			return servletRegistrationBean;
		}

		@Bean
		public FilterRegistrationBean druidStatFilter() {
			System.out.println("filterRegistrationBean configure start.");
			FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new WebStatFilter());
			//添加过滤规则.
			filterRegistrationBean.addUrlPatterns("/*");
			//添加不需要忽略的格式信息.
			filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
			return filterRegistrationBean;
		}
	}
}
