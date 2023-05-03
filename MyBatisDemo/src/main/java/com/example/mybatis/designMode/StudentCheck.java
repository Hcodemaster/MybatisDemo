package com.example.mybatis.designMode;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class StudentCheck implements PersonCheck{
    @Override
    public boolean execute() {
        return true;
    }
}
