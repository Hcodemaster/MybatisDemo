package com.example.mybatis.designMode;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class Teacher extends School{

    @PostConstruct
    public void init(){
        SchoolFactory.register(PersonType.TEACHER.getCode(), this);
    }

    @Override
    public void signature() {
        System.out.println("Teacher signature");
    }

    @Override
    public void takeClass() {
        System.out.println("Teacher take class");
    }
}
