package com.mvc.homework.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoggingInterceptor implements HandlerInterceptor {

    private Logger logger = LoggerFactory.getLogger(LoggingInterceptor.class);

    // 記錄請求的 URL
    @Override
    public boolean preHandle(
		HttpServletRequest request, 
		HttpServletResponse response, 
		Object handler
	) throws Exception {

    	// 驗證使用者是否登入
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect(request.getContextPath() + "/auth/login");
            return false; // 阻止後續處理
        }
    	
        logger.info(String.format("Request URL: [%s] ", request.getRequestURL()));
        return true; // 繼續處理請求
    }

    // 記錄處理器方法和視圖名稱
    @Override
    public void postHandle(
		HttpServletRequest request, 
		HttpServletResponse response, 
		Object handler, 
		ModelAndView modelAndView
	) throws Exception {
        logger.info(String.format("- Handler method: %s", handler));
        if (modelAndView != null) {
            logger.info(String.format("- ModelAndView: %s", modelAndView.getViewName()));
        }
    }

    // 記錄回應狀態碼和可能的異常
    @Override
    public void afterCompletion(
		HttpServletRequest request, 
		HttpServletResponse response, 
		Object handler, 
		Exception ex
    ) throws Exception {
        logger.info(String.format("Request completed with status: %s", response.getStatus()));
        if (ex != null) {
        	logger.error(String.format("Exception: %s", ex.getMessage()));
        }
    }
}