package com.example.mybatis.designMode;

public enum PersonType {
    TEACHER("教师", 0),
    STUDENT("学生", 1);

    public String description;

    public Integer code;

    PersonType(String description, Integer code) {
        this.description = description;
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
