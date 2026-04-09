package org.example.session05.controller;

import org.example.session05.models.Dish;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/bai3")
public class AdminDishController {
    private final AdminDishService service = new AdminDishService();
    @GetMapping("/edit/{id}")
    public String editDish(@PathVariable(name = "id") int id, Model model) {
        System.out.println(id);
        Dish dish = service.findById(id);
        System.out.println(dish.toString());
        if (dish == null) {
            model.addAttribute("error","Không tìm thấy món ăn yêu cầu!");
            return "redirect:/bai2/dishes";
        }
        model.addAttribute("dish", dish);
        return "edit-dish";
    }
}