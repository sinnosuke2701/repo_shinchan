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
	
	public boolean preHandle2(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		if (request.getSession().getAttribute("sessSeqUsr") != null) {
			// by pass
		} else {
			response.sendRedirect(Constants.URL_LOGINFORMUSR);
	        return false;
		}
		
		return HandlerInterceptor.super.preHandle(request, response, handler);
	}
	
//	@Override
//	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
//	        throws Exception {
//
//	    String uri = request.getRequestURI();
//
//	    if (uri.startsWith("/xdm/v1/infra")) { // 관리자 페이지 경로
//	        if (request.getSession().getAttribute("sessSeqXdm") == null) {
//	            response.sendRedirect(Constants.URL_LOGINFORM); // 관리자 로그인 화면
//	            return false;
//	        }
//	    } else if (uri.startsWith("/usr/v1/infra")) { // 사용자 페이지 경로
//	        if (request.getSession().getAttribute("sessSeqUsr") == null) {
//	            response.sendRedirect(Constants.URL_LOGINFORMUSR); // 사용자 로그인 화면
//	            return false;
//	        }
//	    }
//
//	    return HandlerInterceptor.super.preHandle(request, response, handler);
//	}
	
	
	
}
