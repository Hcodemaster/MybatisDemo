package com.example.mybatis.controller;

import com.example.mybatis.designMode.School;
import com.example.mybatis.designMode.SchoolFactory;
import com.example.mybatis.mapper.PersonMapper;
import com.example.mybatis.mapper.UserMapper;
import com.example.mybatis.mapper.UtilMapper;
import com.example.mybatis.model.Person;
import com.example.mybatis.service.MoneyService;
import com.example.mybatis.service.PersonService;
import com.example.mybatis.service.UtilService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Slf4j
@RestController
@RequestMapping("/test")
public class testController {

    @Resource
    PersonMapper personMapper;

    @Resource
    UserMapper userMapper;

    @Resource
    PersonService personService;

    @Resource
    MoneyService moneyService;

    @Resource
    UtilMapper utilMapper;

    @Resource
    UtilService utilService;

    @GetMapping("/mode/{type}")
    public String schoolTest(@PathVariable("type") Integer type){
        School process = SchoolFactory.getProcess(type);
        if(Objects.isNull(process)){
            log.error("找不到处理的模板");
            return "false";
        }
        process.execute();
        return "success";
    }

//    @GetMapping("/batch/insert")
//    public String batchInsert(){
//        List<Person> list = Arrays.asList(new Person("huang", 20), new Person("zhi", 21), new Person("yong", 22));
//        int res = personMapper.batchInsert(list);
//        log.info("批量插入的返回值:{}", res);
//        return "Success";
//    }

    @GetMapping("/update/one")
    public String updateOne(@Param("name") String name, @Param("age") int age){
//        System.out.print(name);
//        personService.updatePerson("huang", age);
////        User huang = userMapper.getUserByName("huang");
////        System.out.println(huang);
        Person huang = personMapper.getPersonByName("huang");
        System.out.println(huang);
        return "Success";
    }

    @GetMapping("/retry")
    public String testRetry() {
        moneyService.getMoney();
        return "ok";
    }

    @GetMapping("/id")
    public String testGetId(@Param("name") String name) {
        Integer id = utilService.getId(name);
        System.out.println("id = " + id);
        return "success get id:" + id;
    }
}
