package org.example.session06.repository;

import org.example.session06.models.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class BookRepository {
    public List<Book> books =  new ArrayList<Book>(
            Arrays.asList(
                    new Book(1,"Doraemon","Fuji",20000),
                    new Book(2,"Lão Hạc","Nam Cao", 25000),
                    new Book(3,"Thúy Kiều", "Nguyễn Du",30000)
            )
    );

}
