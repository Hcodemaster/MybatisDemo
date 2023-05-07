package com.example.mybatis.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UtilMapper {
    public int getIdFromDb(@Param("name") String name);

    public void insertToDb(@Param("name") String name);
}
