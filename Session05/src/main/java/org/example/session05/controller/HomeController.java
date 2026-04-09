package org.example.session05.controller;

import org.example.session05.models.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping
public class HomeController {
    List<Product> productList = new ArrayList<>(
            Arrays.asList(
                    new Product(1,"Nguyễn Trí Thắng",5000,1,true),
                    new Product(2,"Vũ Việt Tiến",3600,1,true),
                    new Product(3,"Hoàng Thái Minh",1800,1,false),
                    new Product(4,"Nguyễn Danh Tuấn",500,1,true)
            )
    );

    @GetMapping("")
    public String home(Model model) {
        model.addAttribute("shop", productList);
        return "home";
    }

}
