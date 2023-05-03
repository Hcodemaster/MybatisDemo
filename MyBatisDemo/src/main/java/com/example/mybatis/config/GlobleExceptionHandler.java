package com.example.mybatis.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@ControllerAdvice
@ResponseBody
public class GlobleExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    public String process(Exception e){
        log.error("Error Msg:{}", e);
        return "Error";
    }
}
