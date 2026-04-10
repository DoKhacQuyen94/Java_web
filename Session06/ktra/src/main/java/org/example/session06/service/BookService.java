package org.example.session06.service;

import org.example.session06.models.Book;
import org.example.session06.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;
    public List<Book> findAll(){
        return bookRepository.books;
    }
    public Book findOne(int id){
//        bookRepository.books.contains(id);
        return bookRepository.books.get(id);
    }
}
