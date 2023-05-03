package com.example.mybatis.service;

import com.example.mybatis.designMode.PersonCheck;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class PersonCheckService {
    @Autowired
    List<PersonCheck> checkList;

    public boolean check(){
        log.info("注入的自定义检查器数量:{}", checkList.size());
        Boolean res = Optional.ofNullable(checkList).orElse(new ArrayList<>()).stream().allMatch(one -> one.execute());
        return  res;
    }

}
