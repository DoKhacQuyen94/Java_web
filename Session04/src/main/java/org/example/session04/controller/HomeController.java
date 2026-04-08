package org.example.session04.controller;

import org.example.session04.models.Student;
import org.example.session04.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

// đánh dấu bean nó là controller
@Controller
// đánh dấu đây là đường dẫn đến controller
@RequestMapping // mặc định là /

// Các annotations phổ biến nhất
/*
-- Các anonotíion không gì bean dùng để khởi tạo và sử dụng DI
* @Componet: đánh dấu là bean để khởi tạo và ko có ngữ nghĩa
* @Controller: đánh dấu là bean và mục đích điều hướng (lễ tân)
* @Service: đánh dấu là bean và mục đích là nghiệp vụ
* @Ropository: đánh dấu là bean và mục đích sử lý tương tác database
* @Autowired: dùng để tiêm sự phục thuộc (DI- dempendency Injection)
* */
public class HomeController {
    @Autowired
    private StudentService studentService;
    // chức năng 1 đường dẫn
    /*
    * Biến của @RequestMapping
    * -- @GetMapping: Đại diện cho phương thức Get
    * -- @PostMapping: Đại diện cho phương thức Post
    * -- @PustMapping: đại diện cho phương thức PUT
    * -- @PathMapping: đại diện cho phương thức PATCH
    * -- @DeleteMapping : đại diện cho phương thức DELETE
    * */
//    @RequestMapping(method = RequestMethod.GET) cách cũ
    @GetMapping
    public  String home(Model model) {
        List<Student> students = studentService.getAllStudents();
        System.out.println("students: " + students);
        model.addAttribute("students", students);
        return "home";
    }

    @GetMapping("/search")
    public String search(
            // name đại diện cho key của tham số
            @RequestParam(name = "keyword",defaultValue = "") String keyword

    ){

        return "Home";
    }
}
