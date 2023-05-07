package com.example.mybatis.service;

import com.example.mybatis.comman.Constant;
import com.example.mybatis.mapper.UtilMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Slf4j
@Service
public class UtilService {

    @Resource
    UtilMapper utilMapper;

    /**
     *
     * @param name 业务名
     * @return
     */
    @Transactional
    public Integer getId(String name) {
        try {
            utilMapper.insertToDb(name);
            Integer res = utilMapper.getIdFromDb(name);
            log.info("获取的id为:{}", res);
            return res;
        }catch (Exception e) {
            log.error("获取id异常", e);
            return Constant.EXCEPTION_ID;
        }

    }
}
