package org.example.session05.service;

import org.example.session05.models.Dish;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DishService {
    public List<Dish> getAllDishes() {
        return List.of(
                new Dish(1, "Cơm chay", 30000, true),
                new Dish(2, "Bún chay", 35000, false),
                new Dish(3, "Lẩu nấm", 120000, true)
        );
    }
}
