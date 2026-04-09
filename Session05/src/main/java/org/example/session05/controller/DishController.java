package org.example.session05.controller;

import org.example.session05.models.Dish;
import org.example.session05.service.DishService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class DishController {

    private final DishService dishService;

    public DishController(DishService dishService) {
        this.dishService = dishService;
    }

    @GetMapping("/bai2/dishes")
    public String getDishes(Model model) {

        model.addAttribute("dishes", dishService.getAllDishes());

        return "dish-list";
    }
    @GetMapping("/bai4/dishes")
    public String listDish(Model model) {
        model.addAttribute("dishes", dishService.getAllDishes());
        return "dish-list";
    }
}