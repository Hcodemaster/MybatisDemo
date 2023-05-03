package com.example.mybatis.mapper;

import com.example.mybatis.model.Person;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PersonMapper {
    public int batchInsert(@Param("list") List<Person> list);

    public int updatePerson(@Param("person") Person person);

    public Person getPersonByName(@Param("name") String name);
}
