package org.example.btth;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    static void main(String[] args) {
        ApplicationContext context = new
                AnnotationConfigApplicationContext(AppConfig.class);
        AccountManagement acc =context.getBean("accountManagement",AccountManagement.class);
        acc.checkYourComputer("Quyền","VIP");
    }
}
