package com.study.app.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.study.app.commons.TokenValidator;

@Configuration
public class interceptorConfig implements WebMvcConfigurer{

	@Autowired
	private TokenValidator testInterceptor;
	
	// Dispatcher랑 Controller 사이에 interceptor 설치
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(testInterceptor)
		.addPathPatterns("/**") // 여기서는 post : interceptor 일단 들어오게하고 tokenValidator에서 따로 설정
		.excludePathPatterns("/auth/login"); // 이 경로로 들어오는건 interceptor를 배제해라(로그인)
	}
}
