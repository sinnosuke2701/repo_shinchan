package com.shinnosuke.common.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;

import com.shinnosuke.common.constants.Constants;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Configuration
public class CheckLoginSessionInterceptor implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		if (request.getSession().getAttribute("sessSeqXdm") != null) {
			// by pass
		} else {
			response.sendRedirect(Constants.URL_LOGINFORM);
	        return false;
		}
		
		return HandlerInterceptor.super.preHandle(request, response, handler);
	}

	
	
}
