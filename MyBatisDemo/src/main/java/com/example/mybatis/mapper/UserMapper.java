package com.example.mybatis.mapper;

import com.example.mybatis.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {
    public User getUserByName(String name);

    @Select("select password from User where name=#{name}")
    public String getPasswordByName(String name);

    public List<User> getUserListByNameList(@Param("nameList") List<String> nameList);

    public Integer updateUserCntByName(@Param("name")  String name, @Param("cnt") Integer cnt, @Param("version") Integer version);
}
