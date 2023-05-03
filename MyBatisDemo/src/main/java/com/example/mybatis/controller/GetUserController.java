package com.example.mybatis.controller;

import com.example.mybatis.model.User;
import com.example.mybatis.config.NeedLogin;
import com.example.mybatis.mapper.UserMapper;
import com.example.mybatis.model.UserEvent;
import com.example.mybatis.service.MoneyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

@Slf4j
@EnableAsync
@RestController
public class GetUserController {

    @Autowired
    UserMapper mapper;

    @Resource
    MoneyService money;

    @Resource
    ApplicationContext applicationContext;

    @NeedLogin
    @GetMapping("/hello")
    public String hello(HttpServletRequest request){
        log.info("print hello world : {}" , request.toString());
        int num = 10 / 0;
        return "Hello World";
    }
    @GetMapping("/User")
    public User getUserByName(String name)
    {
        User user = mapper.getUserByName(name);
        return user;
    }
    @GetMapping("/Password")
    public String getPasswordByName(String name)
    {
        String password = mapper.getPasswordByName(name);
        return password;
    }

    @GetMapping("/list")
    public String getList(){
        List<String> nameList = Arrays.asList("user_1", "user_2");
        mapper.getUserListByNameList(nameList).stream().forEach(System.out::println);
        return "ok";
    }

    @GetMapping("/many")
    public String test(){
        new Thread(() ->{
            try{
                money.transfer1("zhi", 1000);
            }catch (Exception e){
                e.printStackTrace();
            }
        }).start();

        new Thread(() ->{
            try{
                money.transfer2("zhi", 1000);
            }catch (Exception e){
                e.printStackTrace();
            }
        }).start();
        return "ok";
    }

    @GetMapping("/event")
    public String event(){
        UserEvent userEvent = new UserEvent("huang", "123456", 100);
        applicationContext.publishEvent(userEvent);
        log.info("发布事件的线程为:{}", Thread.currentThread().getName());
        for(int i = 0; i < 100; i++){
            try {
                Thread.sleep(50);
            }catch (Exception e){

            }
        }
        return "ok";
    }
}
