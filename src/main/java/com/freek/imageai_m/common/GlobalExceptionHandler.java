package com.freek.imageai_m.common;

//import com.booksdiary.global.error.exception.BusinessException;
//import com.booksdiary.global.error.exception.EntityNotFoundException;
//import com.booksdiary.global.error.exception.InvalidValueException;
import com.freek.imageai_m.diffusion.controller.DiffusionController;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.ErrorResponse;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.nio.file.AccessDeniedException;

/**
 * GlobalExceptionHandler는 다양한 예외에 대한 핸들링 작업을 수행한다.
 * Exception을 상속받은 모든 클래스에 대해 대응하며, ErrorResponse를 ResponseEntity에 담아 반환한다.
 * <p>
 * ref https://cheese10yun.github.io/spring-guide-exception/
 */
@Slf4j(topic = "rolling")
@RestControllerAdvice
public class GlobalExceptionHandler {

//    private static final Logger Logger = LoggerFactory.getLogger(DiffusionController.class);
    /**
     * javax.validation.Valid or @Validated 으로 binding error 발생시 발생한다.
     * HttpMessageConverter 에서 등록한 HttpMessageConverter binding 못할경우 발생
     * 주로 @RequestBody, @RequestPart 어노테이션에서 발생
     */

    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<ErrorResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
//        log.info("handleMethodArgumentNotValidException", e);
        Object ErrorCode;
        final ErrorResponse response = null;//ErrorResponse.of(ErrorCode.INVALID_INPUT_VALUE, e.getBindingResult());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<ErrorResponse> handleException(Exception e) {
//        log.error("Exception", e);
        final ErrorResponse response = null;//ErrorResponse.of(ErrorCode.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}