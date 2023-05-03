package com.example.mybatis.service;

import com.example.mybatis.model.UserEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserEventListener {

    @EventListener
    @Async
    public String processUserEvent(UserEvent event){
        String name = event.getName();
        log.info("当前线程为:{}, 获取处理用户名称为:{}", Thread.currentThread().getName(), event.getName());
        return event.getCnt().toString();
    }
}
