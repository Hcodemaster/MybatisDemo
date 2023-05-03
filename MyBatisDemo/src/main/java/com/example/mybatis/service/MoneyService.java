package com.example.mybatis.service;

import com.example.mybatis.model.User;
import com.example.mybatis.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Slf4j
@Service
public class MoneyService {

    @Resource
    private UserMapper mapper;
    @Resource
    private PersonService personService;

    static Integer errorCount = 0;

    /**
     * 转账业务
     */
    @Transactional
    public void transfer1(String name, int money){
        User user = mapper.getUserByName(name);
        try{
            Thread.sleep(100);
        }catch (Exception e){
            e.printStackTrace();
        }
        //获取当前的账户余额
        int count = user.getCnt();
        log.info("线程" + Thread.currentThread().getName() + " count = {}", count);
        count = count + money;
        //更新余额
        int res = mapper.updateUserCntByName(name, count, 1);
        log.info("线程" + Thread.currentThread().getName() + " update count = {} 更新是否成功? {}", count, (res > 0 ? "成功" : "失败"));
    }

    public void transfer2(String name, int money){
        try{
            Thread.sleep(50);
        }catch (Exception e){
            e.printStackTrace();
        }
        User user = mapper.getUserByName(name);
        //获取当前的账户余额
        int count = user.getCnt();
        log.info("线程" + Thread.currentThread().getName() + " count = {}", count);
        count = count + money;
        //更新余额
        int res = mapper.updateUserCntByName(name, count, 1);
        log.info("线程" + Thread.currentThread().getName() + " update count = {} 更新是否成功? {}", count, (res > 0 ? "成功" : "失败"));
    }

    /**
     * 测试retry注解
     */
    @Retryable(include = Exception.class, maxAttempts = 3)
    public void testRetry() {
        if(errorCount < 3){
            System.out.println("retry !");
            errorCount ++ ;
            throw new RuntimeException("取钱失败");
        }
        System.out.println("get money success !");
    }

    public void getMoney() {
        try {
            testRetry();
        }catch (Exception e) {
            log.error("取钱失败:{}", e);
            System.out.println("取钱失败");
        }
    }

}
