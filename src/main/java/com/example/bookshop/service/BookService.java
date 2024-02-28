package com.example.bookshop.service;

import com.example.bookshop.model.Book;
import com.example.bookshop.repository.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BookService {
    private final BookRepository bookRepository ;
    void save(Book book) {

    }
}
