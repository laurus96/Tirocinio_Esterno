package com.example.hibernate.Service;

import com.example.hibernate.Entity.Book;
import com.example.hibernate.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> getBooks(){
        return (List<Book>) bookRepository.findAll();
    }
}
