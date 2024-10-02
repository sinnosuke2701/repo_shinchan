package com.shinnosuke.common.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.shinnosuke.common.interceptor.CheckLoginSessionInterceptor;

@Configuration
public class WebMvcConfigurerImpl implements WebMvcConfigurer{
	
	 @Override
	    public void addInterceptors(InterceptorRegistry registry) {
			registry.addInterceptor(new CheckLoginSessionInterceptor())
//					.order(1)
					.addPathPatterns("/xdm/v1/infra/**")
					.excludePathPatterns(
							"/resources/**",
//							"/adt/**",
//							"/xdm/**",
							"/xdm/v1/infra/member/signupXdmForm",
							"/xdm/v1/infra/member/signinXdmForm",
							"/xdm/v1/infra/member/signinXdmProc"
			);	
			
		}
	
}
