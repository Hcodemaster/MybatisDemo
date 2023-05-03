package com.example.mybatis.language;

public class language {
    public static void main(String[] args) {
        MyClass myClass = new MyClass();
        StringBuffer buffer = new StringBuffer("hello");
        myClass.changeValue(buffer);
        System.out.println(buffer.toString());
    }

    static class MyClass {

        void changeValue(StringBuffer buffer) {
//            buffer.append("world");
            buffer = new StringBuffer("huang");
        }
    }
}
