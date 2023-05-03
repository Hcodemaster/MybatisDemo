package com.example.mybatis.designMode;

import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

public class SchoolFactory {
    public static ConcurrentHashMap<Integer, School> schoolMap = new ConcurrentHashMap();

    public static void register(Integer type, School school){
        School process = schoolMap.getOrDefault(type, null);
        if(Objects.isNull(process)){
            schoolMap.put(type, school);
        }
    }

    public static School getProcess(Integer type){
        return schoolMap.getOrDefault(type,null);
    }
}
