package org.example.btth;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
public class AppConfig {
    // bean - nomalNotify
    @Bean
    public NormalNotify normalNotify(){
        return new NormalNotify();
    }
    // Bean - vipNotify
    @Bean
    public VipNotify vipNotify(){
        return new VipNotify();
    }
    // Bean - accountManagement
    @Bean
    public AccountManagement accountManagement(){
        Map<String,Double> student = new HashMap<>();
        student.put("Quyền",1000.0);
        student.put("Đoàn",6000.0);
        return new AccountManagement(student);
    }
}
