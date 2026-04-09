package org.example.session05.controller;

import org.example.session05.models.Dish;

import java.util.*;

public class AdminDishService {
    private static final List<Dish> dishes = new ArrayList<>();
    static {
        dishes.add(new Dish(1,"Phở bò",50000,true));
        dishes.add(new Dish(2,"Bún chả",45000,true));
        dishes.add(new Dish(3,"Cơm tấm",40000,false));
    }
    public Dish findById(int id){
        // tìm dish theo id
        for(Dish d : dishes){
            if(d.getId() == id){
                return d;
            }
        }
        return null;
    }
}