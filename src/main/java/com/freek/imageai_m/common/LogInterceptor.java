package com.freek.imageai_m.common;
//package com.booksdiary.controller.common;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.AsyncHandlerInterceptor;
@Slf4j(topic = "DEFAULT_FILE_LOGGER")
@Component
public class LogInterceptor implements AsyncHandlerInterceptor {
    Logger logger = LoggerFactory.getLogger("SampleLogger");

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        logger.info("url : {}", request.getRequestURL());
        logger.info("request : {} response : {}", request.getMethod(), request.getRequestURL());

        return true;
    }
}