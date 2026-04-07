package org.example.ktra.controller;

import org.example.ktra.models.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.*;

@Controller
public class EmployeeController {

    @GetMapping("/employees")
    public String showEmployees(Model model){
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1,"Quyen","IT",3000));
        employees.add(new Employee(2,"Doan","IT",4000));
        employees.add(new Employee(3,"Le","Maketting",5000));

        model.addAttribute("employees", employees);

        return "employee-list";
    }
}