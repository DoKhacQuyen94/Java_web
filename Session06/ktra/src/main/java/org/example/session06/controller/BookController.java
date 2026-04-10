package org.example.session06.controller;

import org.example.session06.models.Book;
import org.example.session06.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping()
public class BookController {
    @Autowired
    private BookService bookService;
    @RequestMapping("/books")
    public String books(Model model){
        List<Book> books = bookService.findAll();
        System.out.println("books size: " + books.size());
        model.addAttribute("books",books);
        return "books";
    }

    @RequestMapping("/books/{id}")
    public String book(@PathVariable(name = "id") int id, Model model){
        Book book = bookService.findOne(id-1);
        model.addAttribute("book",book);
        return "detail";
    }
}
