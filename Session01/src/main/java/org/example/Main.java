package org.example;

import org.example.configs.AppConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    static void main(String[] args) {
        // Bean đọc cấu hình java class
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class);
        // lấy bean ra như nào?
        Person fullStack = context.getBean("fullStack",Person.class);
        System.out.println(fullStack);
    }
}