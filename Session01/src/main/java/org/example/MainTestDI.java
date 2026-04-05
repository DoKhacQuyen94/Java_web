package org.example;

import org.example.configs.AppConfiguration;
import org.example.service.CustomerService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainTestDI {
    static void main(String[] args) {
        ApplicationContext context = new
                AnnotationConfigApplicationContext(AppConfiguration.class);
        CustomerService customerService = (CustomerService) context.getBean("customerService");
        customerService.eat();
        customerService.sleep();
    }
}
