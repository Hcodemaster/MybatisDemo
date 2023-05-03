package com.example.mybatis.designMode;

import com.example.mybatis.service.PersonCheckService;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.Resource;
import javax.transaction.SystemException;

@Slf4j
public abstract class School {

    @Resource
    PersonCheckService personCheckService;

    public abstract void signature();

    public abstract void takeClass();

    public boolean check(){
        return personCheckService.check();
    }
    public void execute(){
        try {
            if(check()){
                log.info("检查结果为true");
                signature();
                takeClass();
            }
        }catch (Exception e){
            log.error("上课过程出现异常:{}", e);
            throw new RuntimeException("上课过程出现异常");
        }
    }
}
