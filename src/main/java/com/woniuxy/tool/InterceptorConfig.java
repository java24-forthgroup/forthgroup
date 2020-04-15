package com.woniuxy.tool;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

	@Bean
	public HandlerInterceptor getLoginInterceptor() {
		return new LoginInterceptor();
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(getLoginInterceptor()).addPathPatterns("/**").excludePathPatterns("/login","/loginAjax","/patient/save","/user/findOneByUname",
				"/logout","/bootstrap/**","/css/**","/jquery/**","/layer/**","/images/**");
	}

}
