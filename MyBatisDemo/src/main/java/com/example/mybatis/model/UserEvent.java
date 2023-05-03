package com.example.mybatis.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.ApplicationEvent;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserEvent  {
    private String name;
    private  String password;

    private  Integer cnt;
}
