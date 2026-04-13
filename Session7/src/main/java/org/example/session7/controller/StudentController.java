package org.example.session7.controller;

import org.example.session7.models.Student;
import org.example.session7.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping()
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping
    public String Home(Model model) {

        model.addAttribute("student", studentRepository.getStudents());

        return "home";
    }

    @GetMapping("/view/add")
    public String Add(Model model) {
        model.addAttribute("student", new Student());
        return "form-add";
  }

    @PostMapping("/hanlde-add")
    public String Add(@ModelAttribute(name = "student") Student student) {
        System.out.println("add student " + student);
        studentRepository.addStudent(student);
        return "redirect:/";

    }
}
