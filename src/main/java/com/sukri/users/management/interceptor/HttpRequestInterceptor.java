package com.sukri.users.management.interceptor;

import com.sukri.users.management.enums.Common4XXExceptionEnum;
import com.sukri.users.management.exception.BaseException;
import com.sukri.users.management.model.ErrorInfo;
import io.micrometer.common.util.StringUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Component
@Slf4j
public class HttpRequestInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String empId = (String) request.getAttribute("empId");
        log.info("EMP ID -- {}", empId);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("Ending ===> {}", request.getPathInfo());
    }
}
