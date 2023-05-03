package com.example.mybatis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.retry.annotation.EnableRetry;

@SpringBootApplication
@EnableRetry
public class MyBatisDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyBatisDemoApplication.class, args);
	}

}
