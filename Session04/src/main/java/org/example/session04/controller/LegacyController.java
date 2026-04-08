package org.example.session04.controller;

import org.example.session04.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller("legacyControllerBai1")
public class LegacyController {
    private OrderService orderService;
    @Autowired
    public LegacyController(OrderService orderService) {
        this.orderService = orderService; // Spring inject
    }
    @GetMapping("/bai1/orders")
    @ResponseBody
    public String getAllOrders() {
        return orderService.getAllOrders();
    }
    @GetMapping("/bai1/orders/{id}")
    @ResponseBody
    public String getOrderById(@PathVariable("id") Long id) {
        // chỉ rõ id để Spring bind chắc chắn
        return orderService.getOrderById(id);
    }
}