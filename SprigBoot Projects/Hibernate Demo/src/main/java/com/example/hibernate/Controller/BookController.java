package com.example.hibernate.Controller;

import com.example.hibernate.Entity.Book;
import com.example.hibernate.Repository.BookRepository;
import com.example.hibernate.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BookController {

    @Autowired
    private BookService bookService;


    @GetMapping("/books")
    public List<Book> allBooks(){
        return bookService.getBooks();
    }

}
