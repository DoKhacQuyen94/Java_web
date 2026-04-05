package org.example.service.impl;

import org.example.service.CustomerService;
import org.example.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component // nó không có nghĩa nhưng nó là bean  khởi tạo
public class CustomerServiceImpl implements CustomerService {
    // DI - tiêm sự phụ thuộc
    @Autowired
    private OrderService orderService; // field

    // Bao nhiêu cách tiêm DI - 3
    // 1. Constructors
//    public CustomerServiceImpl(OrderService orderService){
//        this.orderService = orderService;
//    }
    // 2. setter

//    public void setOrderService(OrderService orderService){
//        this.orderService = orderService;
//    }
    // 3. field

    @Override
    public void eat() {
        orderService.serve();
    }

    @Override
    public void sleep() {
        System.out.println("Đang ngủ ...");
    }
}
