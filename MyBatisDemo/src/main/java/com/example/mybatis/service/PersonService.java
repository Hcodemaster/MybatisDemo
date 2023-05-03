package com.example.mybatis.service;

import com.example.mybatis.mapper.PersonMapper;
import com.example.mybatis.model.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Slf4j
public class PersonService {

    @Resource
    PersonMapper personMapper;

    @Transactional(rollbackFor = Exception.class)
    public void updatePerson(String name, int age){
        log.info("name:{}", name);
        Person person = personMapper.getPersonByName(name);
        log.info("select person :{}", person.toString());
        person.setAge(age);
        int res = personMapper.updatePerson(person);
        log.info("update person res:{}", res);

    }

}
