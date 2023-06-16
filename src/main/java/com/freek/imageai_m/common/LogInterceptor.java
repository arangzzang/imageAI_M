package com.freek.imageai_m.common;
//package com.booksdiary.controller.common;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.AsyncHandlerInterceptor;
@Slf4j(topic = "rolling")
@Component
public class LogInterceptor implements AsyncHandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
//        log.info("url : {}", request.getRequestURL());
//        log.info("request : {} response : {}", request.getMethod(), request.getRequestURL());

        return true;
    }
}