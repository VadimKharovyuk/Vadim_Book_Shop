package com.example.bookshop.service;

import com.example.bookshop.model.Book;
import com.example.bookshop.repository.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BookService {
    private final BookRepository bookRepository ;
  public  void save(Book book) {
      bookRepository.save(book);

    }

    public List<Book> findAll(Book book){
      return bookRepository.findAll();

    }
    public Book getBookById(Long id){
      return bookRepository.findById(id).get();
    }
}
