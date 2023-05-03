package com.example.mybatis;

import com.example.mybatis.mapper.PersonMapper;
import com.example.mybatis.model.Person;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class MyBatisDemoApplicationTests {
	@Resource
	PersonMapper personMapper;

	@Test
	void contextLoads() {

	}
	@Test
	void testMapper(){
		Person huang = personMapper.getPersonByName("huang");
		System.out.println(huang);
	}

}
