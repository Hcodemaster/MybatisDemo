package com.example.mybatis.designMode;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class Student extends School{
    @PostConstruct
    public void init(){
        SchoolFactory.register(PersonType.STUDENT.getCode(), this);
    }

    @Override
    public void signature() {
        System.out.println("Student signature");
    }

    @Override
    public void takeClass() {
        System.out.println("Student take Class");
    }
}
