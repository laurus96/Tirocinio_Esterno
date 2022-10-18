package com.example.hibernate.Repository;

import com.example.hibernate.Entity.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
