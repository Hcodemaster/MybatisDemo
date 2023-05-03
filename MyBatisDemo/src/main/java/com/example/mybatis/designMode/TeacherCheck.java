package com.example.mybatis.designMode;

import org.springframework.stereotype.Component;

@Component
public class TeacherCheck implements PersonCheck{
    @Override
    public boolean execute() {
        return true;
    }
}
