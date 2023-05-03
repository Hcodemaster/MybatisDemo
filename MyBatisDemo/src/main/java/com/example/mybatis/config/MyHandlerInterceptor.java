package com.example.mybatis.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

@Slf4j
public class MyHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(handler instanceof HandlerMethod){
            HandlerMethod method = (HandlerMethod) handler;
            NeedLogin needLogin = method.getMethodAnnotation(NeedLogin.class);
            if(Objects.nonNull(needLogin)){
                log.info("用户需要登录，拒绝访问");
                return true;
            }
        }
        return true;
    }
}
